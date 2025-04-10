package com.example.agdesk.fragments

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.agdesk.databinding.FragmentAddAssetBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import java.io.File
import java.io.FileOutputStream

class AddAssetFragment : Fragment() {

    private var binding: FragmentAddAssetBinding? = null
    private val TAG = "AddAssetFragment"
    private var qrBitmap: Bitmap? = null // Store the generated QR code

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddAssetBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.ivBack?.setOnClickListener { Navigation.findNavController(it).navigateUp() }

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
