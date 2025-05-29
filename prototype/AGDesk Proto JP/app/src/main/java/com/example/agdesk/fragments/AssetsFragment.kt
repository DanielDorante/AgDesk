package com.example.agdesk.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.agdesk.R
import com.example.agdesk.ViewModels.AssetViewModel
import com.example.agdesk.adapters.AssetsAdapter
import com.example.agdesk.databinding.FragmentAssetsBinding
import com.example.agdesk.models.UIModels.AssetModel
import com.example.agdesk.models.OnClick
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date
import java.util.Locale
import java.util.UUID
import kotlin.getValue

@AndroidEntryPoint
class AssetsFragment : Fragment(), OnClick, AssetsAdapter.AssetItemListener {
    private var _binding: FragmentAssetsBinding? = null
    private val binding get() = _binding!!
    var listOfAssets: List<AssetModel> = ArrayList()
    lateinit var assetsAdapter: AssetsAdapter
    private val assetViewModel: AssetViewModel by viewModels()

    companion object {
        const val ARG_ASSET = "asset"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAssetsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the RecyclerView
        binding.rvInventory.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        assetsAdapter = AssetsAdapter(requireContext(), listOfAssets, this, this)
        binding.rvInventory.adapter = assetsAdapter

        // Navigate to Add Asset screen when FAB is clicked
        binding.fabAddAsset.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_assets_to_addAssetFragment)
        }

        // Set up search functionality
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // No action needed
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // No action needed
            }

            override fun afterTextChanged(s: Editable) {
                if (s.toString().isEmpty()) {
                    assetsAdapter.setList(listOfAssets)
                } else {
                    filter(s.toString())
                }
            }
        })

        // Observe assets from ViewModel
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                assetViewModel.assets.collectLatest { assets ->
                    listOfAssets = assets
                    assetsAdapter.setList(assets)
                }
            }
        }
    }

    // AssetItemListener implementation
    override fun onEditClick(asset: AssetModel) {
        // Create a bundle to pass the asset to AddAssetFragment
        val bundle = Bundle().apply {
            putSerializable(ARG_ASSET, asset)
        }

        // Navigate to AddAssetFragment with the asset data using Navigation component
        findNavController().navigate(R.id.action_navigation_assets_to_addAssetFragment, bundle)
    }

    override fun onDeleteClick(asset: AssetModel) {
        // Show confirmation dialog before deleting
        AlertDialog.Builder(requireContext())
            .setTitle("Delete Asset")
            .setMessage("Are you sure you want to delete this asset?")
            .setPositiveButton("Delete") { _, _ ->
                // Delete the asset using ViewModel
                lifecycleScope.launch {
                    assetViewModel.deleteAsset(asset)
                }
                Toast.makeText(requireContext(), "Asset deleted successfully", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    override fun onResume() {
        super.onResume()

        // Load all assets when the fragment resumes
        assetViewModel.loadAssets()
    }

    private fun showAssetDialog(asset: AssetModel) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_asset_details, null)
        val dialog = AlertDialog.Builder(requireContext()).setView(dialogView).create()

        val ivAssetImage: ImageView = dialogView.findViewById(R.id.ivAssetImage)
        val ivClose: ImageView = dialogView.findViewById(R.id.ivClose)
        val tvAssetName: TextView = dialogView.findViewById(R.id.tvAssetName)
        val tvAssetStatus: TextView = dialogView.findViewById(R.id.tvAssetStatus)
        val btnCheckIn: Button = dialogView.findViewById(R.id.btnCheckIn)
        val tvPrefix: TextView = dialogView.findViewById(R.id.tvPrefix)
        val tvManufacturer: TextView = dialogView.findViewById(R.id.tvManufacturer)
        val tvLocation: TextView = dialogView.findViewById(R.id.tvLocation)
        val tvVin: TextView = dialogView.findViewById(R.id.tvVin)
        val tvSerialNo: TextView = dialogView.findViewById(R.id.tvSerialNo)
        val tvDateMade: TextView = dialogView.findViewById(R.id.tvDateMade)
        val tvDatePurchased: TextView = dialogView.findViewById(R.id.tvDatePurchased)
        val tvRegistration: TextView = dialogView.findViewById(R.id.tvRegistration)
        val tvParts: TextView = dialogView.findViewById(R.id.tvParts)
        val tvFarmId: TextView = dialogView.findViewById(R.id.tvFarmId)

        Glide.with(ivAssetImage).load(asset.image).into(ivAssetImage)
        tvAssetName.text = asset.name
        tvAssetStatus.text = if (asset.checkoutStatus == true) "Checked Out" else "Checked In"
        tvPrefix.text = "Prefix: ${asset.assetPrefix}"
        tvManufacturer.text = "Manufacturer: ${asset.manufac}"
        tvLocation.text = "Location: ${asset.location}"
        tvVin.text = "VIN: ${asset.vin}"
        tvSerialNo.text = "Serial No: ${asset.serialNo}"
        tvDateMade.text = "Date Made: ${asset.dateMade}"
        tvDatePurchased.text = "Date Purchased: ${asset.dateBuy}"
        tvRegistration.text = "Registration #: ${asset.reg}"
        tvParts.text = "Parts: ${asset.parts}"
        tvFarmId.text = "Farm ID: ${asset.farmId}"

        if (asset.checkoutStatus == true){
            tvAssetStatus.text = "Checked out"
            tvAssetStatus.setTextColor(requireContext().getColor(R.color.red))
            btnCheckIn.text = "Check in"
            btnCheckIn.setBackgroundColor(requireContext().getColor(R.color.dark_main))
        }else{
            tvAssetStatus.text = "Checked in"
            tvAssetStatus.setTextColor(requireContext().getColor(R.color.dark_main))
            btnCheckIn.text = "Check out"
            btnCheckIn.setBackgroundColor(requireContext().getColor(R.color.red))
        }

        btnCheckIn.setOnClickListener {
            if (asset.checkoutStatus!!){
                asset.checkoutStatus = false
                // Update the asset status through ViewModel
                viewLifecycleOwner.lifecycleScope.launch {
                    assetViewModel.updateAsset(asset)
                }

                tvAssetStatus.text = "Checked out"
                tvAssetStatus.setTextColor(requireContext().getColor(R.color.red))
                btnCheckIn.text = "Check out"
                btnCheckIn.setBackgroundColor(requireContext().getColor(R.color.dark_main))
            }else{
                asset.checkoutStatus = true
                // Update the asset status through ViewModel
                viewLifecycleOwner.lifecycleScope.launch {
                    assetViewModel.updateAsset(asset)
                }

                tvAssetStatus.text = "Checked in"
                tvAssetStatus.setTextColor(requireContext().getColor(R.color.dark_main))
                btnCheckIn.text = "Check in"
                btnCheckIn.setBackgroundColor(requireContext().getColor(R.color.red))
            }

            dialog.dismiss()
            // No need to manually update the list as the StateFlow observer will handle it
        }

        ivClose.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }

    fun filter(text: String) {
        val filteredList: MutableList<AssetModel> = ArrayList()
        for (model in listOfAssets) {
            if (model.name?.lowercase(Locale.ROOT)
                    ?.contains(text.lowercase(Locale.getDefault())) == true
            ) {
                filteredList.add(model)
            }
        }
        assetsAdapter.setList(filteredList)
    }

    override fun clicked(pos: Int) {
        val asset = listOfAssets[pos]
        showAssetDialog(asset)
    }

}