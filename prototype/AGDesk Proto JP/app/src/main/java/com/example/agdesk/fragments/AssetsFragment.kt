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
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.agdesk.R
import com.example.agdesk.ViewModels.TaskViewModel
import com.example.agdesk.adapters.AssetsAdapter
import com.example.agdesk.database.DatabaseHelper
import com.example.agdesk.databinding.FragmentAssetsBinding
import com.example.agdesk.models.AssetModel
import com.example.agdesk.models.OnClick
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale
import java.util.UUID
import kotlin.getValue

@AndroidEntryPoint
class AssetsFragment : Fragment(), OnClick {
    private var _binding: FragmentAssetsBinding? = null
    private val binding get() = _binding!!
    var listOfAssets: List<AssetModel> = ArrayList()
    lateinit var databaseHelper: DatabaseHelper
    lateinit var assetsAdapter: AssetsAdapter
    private val taskViewModel: TaskViewModel by viewModels()

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

        databaseHelper = DatabaseHelper(requireContext())
        binding.rvInventory.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        assetsAdapter = AssetsAdapter(requireContext(), listOfAssets, this)
        binding.rvInventory.adapter = assetsAdapter
        binding.fabAddAsset.setOnClickListener { Navigation.findNavController(it).navigate(R.id.action_navigation_assets_to_addAssetFragment) }

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

    }

    override fun onResume() {
        super.onResume()

        checkAndInsertDefaultAssets()

    }

    fun checkAndInsertDefaultAssets() {
        listOfAssets = databaseHelper.getAllAssets()
        if (listOfAssets.isEmpty()) {
            listOfAssets = listOf(
                AssetModel(null, "LV", "Tractor", "John Deere", "Engine, Wheels", "Farm A", 2015, 2016, "https://4.imimg.com/data4/KJ/BY/MY-14831048/john-deere-5050d-tractor-500x500.jpg", 1, 12345, 67890, 98765, 1, false, ""),
                AssetModel(null, "HV", "Harvester", "Case IH", "Blades, Engine", "Farm B", 2018, 2019, "https://www.bewindia.co/wp-content/uploads/2019/09/Greengold-220-Wheel.jpg", 2, 54321, 98765, 67890, 2, false, ""),
                AssetModel(null, "SE", "Seeder", "Kubota", "Discs, Frame", "Farm C", 2020, 2021, "https://www.deere.ca/assets/images/region-4/products/frontier-implements/seeding-equipment/overseeder/gs/4060l/4391504_gs4060l_1024x576_large_42360ca7adfd8fb22b90aabefac6f25546a154f5.jpg", 3, 11111, 22222, 33333, 3, false, ""),
                AssetModel(null, "LE", "Loader", "CAT", "Hydraulics, Frame", "Farm D", 2012, 2013, "https://www.wesgroupequipment.com/media/CACHE/images/equipment-model-photos/77FD56uQ_MOp88XS/d8edcc17817fb1ff41797a7d48b77266.jpg", 4, 44444, 55555, 66666, 4, false, ""),
                AssetModel(null, "LV", "Plow", "New Holland", "Blades, Frame", "Farm E", 2017, 2018, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlTv1WO054B7ZuCnZoFimjQCWlzMcngrfeRg&s", 5, 77777, 88888, 99999, 5, false, ""),
                AssetModel(null, "HV", "Sprayer", "John Deere", "Nozzles, Tank", "Farm F", 2014, 2015, "https://ik.imagekit.io/tuc2020/wp-content/uploads/2021/03/HW0422.jpg", 6, 13579, 24680, 97531, 6, false, ""),
                AssetModel(null, "SE", "Baler", "CLAAS", "Rollers, Frame", "Farm G", 2019, 2020, "https://dealerwebcentral.s3.amazonaws.com/webres/john-deere-images/560m-megawide-hc%C2%B2-round-baler.jpeg", 7, 11121, 22232, 33343, 7, false, ""),
                AssetModel(null, "LE", "Tiller", "Mahindra", "Blades, Engine", "Farm H", 2016, 2017, "https://pakistanpowertools.com/cdn/shop/files/PG0717001_194c088a-bf06-4446-ba55-7f519be65fcd.jpg?v=1691870063", 8, 44454, 55565, 66676, 8, false, "")
            )

            listOfAssets.forEach { databaseHelper.insertAsset(it) }
            assetsAdapter.setList(listOfAssets)
        }else{
            assetsAdapter.setList(listOfAssets)
        }

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

        if (asset.checkoutStatus!!){
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
                databaseHelper.updateAsset(asset)
                tvAssetStatus.text = "Checked out"
                tvAssetStatus.setTextColor(requireContext().getColor(R.color.red))
                btnCheckIn.text = "Check out"
                btnCheckIn.setBackgroundColor(requireContext().getColor(R.color.dark_main))
            }else{
                asset.checkoutStatus = true
                databaseHelper.updateAsset(asset)
                tvAssetStatus.text = "Checked in"
                tvAssetStatus.setTextColor(requireContext().getColor(R.color.dark_main))
                btnCheckIn.text = "Check in"
                btnCheckIn.setBackgroundColor(requireContext().getColor(R.color.red))
            }
            listOfAssets = databaseHelper.getAllAssets()
            assetsAdapter.setList(listOfAssets)
            dialog.dismiss()
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