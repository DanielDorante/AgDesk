package com.example.agdesk.fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.agdesk.R
import com.example.agdesk.ViewModels.AssetViewModel
import com.example.agdesk.databinding.FragmentAddAssetBinding
import com.example.agdesk.models.UIModels.AssetModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.UUID


@AndroidEntryPoint
class AddAssetFragment : Fragment() {

    private var binding: FragmentAddAssetBinding? = null
    private val TAG = "AddAssetFragment"
    private val assetViewModel: AssetViewModel by viewModels()
    private var qrBitmap: Bitmap? = null // Store the generated QR code
    private var selectedImageUri: Uri? = null
    private val calendar = Calendar.getInstance()
    private var selectedDateManufactured: Date? = null
    private var selectedDatePurchased: Date? = null

    // Track whether we're editing an existing asset
    private var isEditMode = false
    private var existingAsset: AssetModel? = null

    // Constants for asset prefixes
    companion object {
        private const val PREFIX_LV = "LV" // Light Vehicle
        private const val PREFIX_HV = "HV" // Heavy Vehicle
        private const val PREFIX_SE = "SE" // Special Equipment
        private const val PREFIX_LE = "LE" // Light Equipment

        const val ARG_ASSET = "asset"
    }

    // Launch image picker activity
    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            selectedImageUri = it
            binding?.ivAssetImage?.setImageURI(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            if (args.containsKey(ARG_ASSET)) {
                existingAsset = args.getSerializable(ARG_ASSET) as? AssetModel
                isEditMode = existingAsset != null
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddAssetBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigation
        binding?.ivBack?.setOnClickListener { findNavController().navigateUp() }

        // Set up asset prefix spinner
        setupAssetPrefixSpinner()

        // Set up date pickers
        setupDatePickers()

        // Set up image upload
        setupImageUpload()

        // Update UI based on mode (add or edit)
        setupUI()

        // QR Code functionality
        binding?.btnScanQR?.setOnClickListener {
            startQRScanner()
        }

        binding?.btnGenerateQR?.setOnClickListener {
            showGenerateQRDialog()
        }

        // Handle QR Code Click to Share
        binding?.ivQRCode?.setOnClickListener {
            qrBitmap?.let { bitmap ->
                val imageUri = saveBitmapToCache(bitmap)
                if (imageUri != null) {
                    shareImage(imageUri)
                } else {
                    Toast.makeText(requireContext(), "Failed to share QR Code", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Save button
        binding?.btnSaveAsset?.setOnClickListener {
            saveAsset()
        }
    }

    private fun setupUI() {
        if (isEditMode) {
            // Set title for edit mode
            binding?.tvTitle?.text = "Edit Asset"
            binding?.btnSaveAsset?.text = "Update"

            // Populate fields with existing asset data
            existingAsset?.let { asset ->
                binding?.etAssetName?.setText(asset.name)
                binding?.etManufacturer?.setText(asset.manufac)
                binding?.etParts?.setText(asset.parts)
                binding?.etLocation?.setText(asset.location)
                binding?.etFarmId?.setText(asset.farmId?.toString() ?: "")

                // Set VIN, Serial Number, and Registration based on asset type
                binding?.etVin?.setText(asset.vin ?: "")
                binding?.etSerialNo?.setText(asset.serialNo ?: "")
                binding?.etRegistration?.setText(asset.reg ?: "")

                // Set dates if available
                asset.dateMade?.let { dateMade ->
                    val calendar = Calendar.getInstance()
                    calendar.time = dateMade
                    selectedDateManufactured = dateMade
                    val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    binding?.etDateManufactured?.setText(format.format(dateMade))
                }

                asset.dateBuy?.let { dateBuy ->
                    val calendar = Calendar.getInstance()
                    calendar.time = dateBuy
                    selectedDatePurchased = dateBuy
                    val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    binding?.etDatePurchased?.setText(format.format(dateBuy))
                }

                // Set asset prefix spinner
                val prefixPosition = when (asset.assetPrefix) {
                    PREFIX_LV -> 0
                    PREFIX_HV -> 1
                    PREFIX_SE -> 2
                    PREFIX_LE -> 3
                    else -> 0
                }
                binding?.spinnerAssetPrefix?.setSelection(prefixPosition)

                // Load image if available
                asset.image?.let { imageUri ->
                    if (imageUri.isNotEmpty()) {
                        selectedImageUri = Uri.parse(imageUri)
                        Glide.with(requireContext())
                            .load(selectedImageUri)
                            .into(binding?.ivAssetImage!!)
                    }
                }
            }
        } else {
            // Set title for add mode
            binding?.tvTitle?.text = "Add Asset"
            binding?.btnSaveAsset?.text = "Save"
        }
    }

    private fun setupAssetPrefixSpinner() {
        val assetPrefixes = arrayOf(PREFIX_LV, PREFIX_HV, PREFIX_SE, PREFIX_LE)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, assetPrefixes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding?.spinnerAssetPrefix?.adapter = adapter
        binding?.spinnerAssetPrefix?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateFormFieldsVisibility(assetPrefixes[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        // Set default visibility
        updateFormFieldsVisibility(PREFIX_LV)
    }

    private fun updateFormFieldsVisibility(assetPrefix: String) {
        when (assetPrefix) {
            PREFIX_LV, PREFIX_HV -> {
                // Show VIN and Registration for LV and HV
                binding?.layoutVin?.visibility = View.VISIBLE
                binding?.layoutSerialNo?.visibility = View.GONE
                binding?.layoutRegistration?.visibility = View.VISIBLE
            }
            PREFIX_SE -> {
                // Show only Serial Number for SE
                binding?.layoutVin?.visibility = View.GONE
                binding?.layoutSerialNo?.visibility = View.VISIBLE
                binding?.layoutRegistration?.visibility = View.GONE
            }
            PREFIX_LE -> {
                // Show only VIN for LE
                binding?.layoutVin?.visibility = View.VISIBLE
                binding?.layoutSerialNo?.visibility = View.GONE
                binding?.layoutRegistration?.visibility = View.GONE
            }
        }
    }

    private fun setupDatePickers() {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        // Date Manufactured picker
        binding?.etDateManufactured?.setOnClickListener {
            showDatePicker { date ->
                binding?.etDateManufactured?.setText(dateFormat.format(date))
                selectedDateManufactured = date
            }
        }

        binding?.ivDateManufacturedPicker?.setOnClickListener {
            binding?.etDateManufactured?.performClick()
        }

        // Date Purchased picker
        binding?.etDatePurchased?.setOnClickListener {
            showDatePicker { date ->
                binding?.etDatePurchased?.setText(dateFormat.format(date))
                selectedDatePurchased = date
            }
        }

        binding?.ivDatePurchasedPicker?.setOnClickListener {
            binding?.etDatePurchased?.performClick()
        }
    }

    private fun showDatePicker(onDateSelected: (Date) -> Unit) {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                calendar.set(selectedYear, selectedMonth, selectedDay)
                onDateSelected(calendar.time)
            },
            year,
            month,
            day
        ).show()
    }

    private fun setupImageUpload() {
        binding?.btnUploadImage?.setOnClickListener {
            pickImage.launch("image/*")
        }
    }

    private fun saveAsset() {
        // Validate required fields
        if (binding?.etAssetName?.text.isNullOrEmpty()) {
            Toast.makeText(requireContext(), "Asset name is required", Toast.LENGTH_SHORT).show()
            return
        }

        // Get asset prefix
        val assetPrefix = binding?.spinnerAssetPrefix?.selectedItem.toString()

        // Validate fields based on asset prefix
        when (assetPrefix) {
            PREFIX_LV, PREFIX_HV -> {
                if (binding?.etVin?.text.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), "VIN is required for $assetPrefix", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            PREFIX_SE -> {
                if (binding?.etSerialNo?.text.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), "Serial Number is required for $assetPrefix", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            PREFIX_LE -> {
                if (binding?.etVin?.text.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), "VIN is required for $assetPrefix", Toast.LENGTH_SHORT).show()
                    return
                }
            }
        }

        if (isEditMode) {
            // Update existing asset
            existingAsset?.let { asset ->
                val updatedAsset = AssetModel(
                    uid = asset.uid,
                    assetPrefix = assetPrefix,
                    name = binding?.etAssetName?.text?.toString(),
                    manufac = binding?.etManufacturer?.text?.toString(),
                    parts = binding?.etParts?.text?.toString(),
                    location = binding?.etLocation?.text?.toString(),
                    dateMade = selectedDateManufactured,
                    dateBuy = selectedDatePurchased,
                    image = selectedImageUri?.toString() ?: asset.image, // Keep existing image if not changed
                    farmId = binding?.etFarmId?.text?.toString()?.toLongOrNull(),
                    vin = if (assetPrefix == PREFIX_LV || assetPrefix == PREFIX_HV || assetPrefix == PREFIX_LE)
                        binding?.etVin?.text?.toString() else null,
                    serialNo = if (assetPrefix == PREFIX_SE) binding?.etSerialNo?.text?.toString() else null,
                    reg = if (assetPrefix == PREFIX_LV || assetPrefix == PREFIX_HV)
                        binding?.etRegistration?.text?.toString() else null,
                    checkoutStatus = asset.checkoutStatus,
                    checkoutBy = asset.checkoutBy
                )

                // Update the asset using the ViewModel
                lifecycleScope.launch {
                    try {
                        assetViewModel.updateAsset(updatedAsset)
                        Toast.makeText(requireContext(), "Asset updated successfully", Toast.LENGTH_SHORT).show()
                        // Navigate back
                        findNavController().navigateUp()
                    } catch (e: Exception) {
                        Log.e(TAG, "Error updating asset: ${e.message}")
                        Toast.makeText(requireContext(), "Failed to update asset: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } else {
            // Create new asset
            val asset = AssetModel(
                uid = null,
                assetPrefix = assetPrefix,
                name = binding?.etAssetName?.text?.toString(),
                manufac = binding?.etManufacturer?.text?.toString(),
                parts = binding?.etParts?.text?.toString(),
                location = binding?.etLocation?.text?.toString(),
                dateMade = selectedDateManufactured,
                dateBuy = selectedDatePurchased,
                image = selectedImageUri?.toString(), // Save URI as string
                farmId = binding?.etFarmId?.text?.toString()?.toLongOrNull(),
                vin = if (assetPrefix == PREFIX_LV || assetPrefix == PREFIX_HV || assetPrefix == PREFIX_LE)
                    binding?.etVin?.text?.toString() else null,
                serialNo = if (assetPrefix == PREFIX_SE) binding?.etSerialNo?.text?.toString() else null,
                reg = if (assetPrefix == PREFIX_LV || assetPrefix == PREFIX_HV)
                    binding?.etRegistration?.text?.toString() else null,
                checkoutStatus = false,
                checkoutBy = null
            )

            // Save the asset using the ViewModel
            lifecycleScope.launch {
                try {
                    assetViewModel.insertAsssets(asset)
                    Toast.makeText(requireContext(), "Asset saved successfully", Toast.LENGTH_SHORT).show()
                    // Navigate back
                    findNavController().navigateUp()
                } catch (e: Exception) {
                    Log.e(TAG, "Error saving asset: ${e.message}")
                    Toast.makeText(requireContext(), "Failed to save asset: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun showGenerateQRDialog() {
        val dialogView = layoutInflater.inflate(com.example.agdesk.R.layout.dialog_generate_qr, null)
        val dialog = AlertDialog.Builder(requireContext()).setView(dialogView).create()

        val ivClose: ImageView = dialogView.findViewById(com.example.agdesk.R.id.ivClose)
        val etGlobalId: EditText = dialogView.findViewById(com.example.agdesk.R.id.etGlobalId)
        val btnGenerateQR: Button = dialogView.findViewById(com.example.agdesk.R.id.btnGenerateQR)

        btnGenerateQR.setOnClickListener {
            val globalId = etGlobalId.text.toString()
            if (globalId.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter global id", Toast.LENGTH_SHORT).show()
            } else {
                qrBitmap = generateQRCode(globalId)
                if (qrBitmap != null) {
                    binding?.ivQRCode?.setImageBitmap(qrBitmap)
                    binding?.ivQRCode?.visibility = View.VISIBLE
                } else {
                    Toast.makeText(requireContext(), "QR Code Generation Failed!", Toast.LENGTH_SHORT).show()
                }
                dialog.dismiss()
            }
        }

        ivClose.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }

    private fun startQRScanner() {
        com.google.zxing.integration.android.IntentIntegrator.forSupportFragment(this).apply {
            setDesiredBarcodeFormats(com.google.zxing.integration.android.IntentIntegrator.QR_CODE)
            setPrompt("Scan a QR Code")
            setCameraId(0) // Use back camera
            setBeepEnabled(false)
            setBarcodeImageEnabled(false)
            initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result: com.google.zxing.integration.android.IntentResult =
            com.google.zxing.integration.android.IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result.contents != null) {
            Log.d(TAG, "QR Code Scanned: ${result.contents}")
            binding?.tvAssetDetails?.text = result.contents
            binding?.tvAssetDetails?.visibility = View.VISIBLE
        } else {
            Toast.makeText(requireContext(), "QR Scan Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

    private fun generateQRCode(content: String): Bitmap? {
        try {
            val width = 500
            val height = 500
            val bitMatrix: BitMatrix = MultiFormatWriter().encode(
                content, BarcodeFormat.QR_CODE, width, height
            )

            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
            for (x in 0 until width) {
                for (y in 0 until height) {
                    bitmap.setPixel(
                        x,
                        y,
                        if (bitMatrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE
                    )
                }
            }
            return bitmap
        } catch (e: WriterException) {
            Log.e(TAG, "QR Code Generation Failed: ${e.message}")
            return null
        }
    }

    private fun saveBitmapToCache(bitmap: Bitmap): Uri? {
        return try {
            val cachePath = File(requireContext().cacheDir, "images")
            cachePath.mkdirs()
            val file = File(cachePath, "qr_code.png")
            val stream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.close()
            FileProvider.getUriForFile(requireContext(), requireContext().packageName + ".provider", file)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to save QR Code: ${e.message}")
            null
        }
    }

    private fun shareImage(imageUri: Uri) {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, imageUri)
            type = "image/png"
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        startActivity(Intent.createChooser(shareIntent, "Share QR Code"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
