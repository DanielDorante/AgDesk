package com.example.agdesk.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agdesk.R
import com.example.agdesk.adapters.InventoryAdapter

import com.example.agdesk.ViewModels.InventoryViewModel
import com.example.agdesk.databinding.FragmentInventoryBinding
import com.example.agdesk.models.UIModels.InventoryModel
import com.example.agdesk.models.UIModels.Supplier
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale
import kotlin.getValue

@AndroidEntryPoint
class InventoryFragment : Fragment() {

    private var _binding: FragmentInventoryBinding? = null
    private val binding get() = _binding!!
    private val inventoryViewModel: InventoryViewModel by viewModels()
    var listOfInventories: ArrayList<InventoryModel> = ArrayList()
    lateinit var inventoryAdapter: InventoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInventoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            withContext(Dispatchers.Default) {
                inventoryViewModel.loadItems()

                inventoryViewModel.items.collect {savedTasks ->
                    listOfInventories.clear()
                    listOfInventories.addAll(savedTasks)

                }
            }

        }
        setAdapter()
        setSortSpinner()
        binding.fabAddInventory.setOnClickListener {
            showAddInventoryDialog()
        }

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // No action needed
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // No action needed
            }

            override fun afterTextChanged(s: Editable) {
                if (s.toString().isEmpty()) {
                    inventoryAdapter.setList(listOfInventories)
                } else {
                    filter(s.toString())
                }
            }
        })

    }

    private fun setAdapter() {
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvInventory.layoutManager = layoutManager
        inventoryAdapter = InventoryAdapter(listOfInventories)
        binding.rvInventory.adapter = inventoryAdapter
    }

    private fun showAddInventoryDialog() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.item_add_inventory, null)
        val dialog = android.app.AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // Initialize views in the dialog - Basic inventory fields
        val etName = dialogView.findViewById<EditText>(R.id.etName)
        val etSku = dialogView.findViewById<EditText>(R.id.etSku)
        val etCategory = dialogView.findViewById<EditText>(R.id.etCategory)
        val etQuantity = dialogView.findViewById<EditText>(R.id.etQuantity)
        val etCostPrice = dialogView.findViewById<EditText>(R.id.etCostPrice)
        val etSalePrice = dialogView.findViewById<EditText>(R.id.etSalePrice)

        // Supplier fields
        val etSupplierName = dialogView.findViewById<EditText>(R.id.etSupplierName)
        val etSupplierEmail = dialogView.findViewById<EditText>(R.id.etSupplierEmail)
        val etSupplierPhone = dialogView.findViewById<EditText>(R.id.etSupplierPhone)

        // Buttons
        val btnAddNow = dialogView.findViewById<MaterialButton>(R.id.btnAddNow)
        val btnCancel = dialogView.findViewById<MaterialButton>(R.id.btnCancel)

        btnAddNow.setOnClickListener {
            // Get all field values
            val name = etName.text.toString().trim()
            val sku = etSku.text.toString().trim()
            val category = etCategory.text.toString().trim()
            val quantityStr = etQuantity.text.toString().trim()
            val costPriceStr = etCostPrice.text.toString().trim()
            val salePriceStr = etSalePrice.text.toString().trim()

            // Supplier info
            val supplierName = etSupplierName.text.toString().trim()
            val supplierEmail = etSupplierEmail.text.toString().trim()
            val supplierPhone = etSupplierPhone.text.toString().trim()

            // Validate required fields
            if (name.isNotEmpty() && quantityStr.isNotEmpty()) {
                // Convert numeric fields
                val quantity = quantityStr.toIntOrNull() ?: 0
                val costPrice = costPriceStr.toDoubleOrNull()
                val salePrice = salePriceStr.toDoubleOrNull()

                // Create supplier object if any supplier field is provided
                val supplier = if (supplierName.isNotEmpty() || supplierEmail.isNotEmpty() || supplierPhone.isNotEmpty()) {
                    Supplier(
                        name = supplierName.ifEmpty { null },
                        email = supplierEmail.ifEmpty { null },
                        phone = supplierPhone.ifEmpty { null }
                    )
                } else null

                lifecycleScope.launch {
                    withContext(Dispatchers.Default) {
                        val inventoryItem = InventoryModel(
                            uid = null,
                            name = name,
                            sku = sku.ifEmpty { null },
                            category = category.ifEmpty { null },
                            quantity = quantity,
                            costPrice = costPrice,
                            salePrice = salePrice,
                            supplier = supplier
                        )
                        inventoryViewModel.insertItems(inventoryItem)
                    }
                    withContext(Dispatchers.Main) {
                        dialog.dismiss()
                        Toast.makeText(requireContext(), "Inventory added successfully", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Please enter at least name and quantity", Toast.LENGTH_SHORT).show()
            }
        }

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setSortSpinner() {

        val sortList = arrayOf("All", "Available")

        val adapter = ArrayAdapter(
            requireActivity(),
            R.layout.item_sort, sortList
        )
        binding.spSort.adapter = adapter

        binding.spSort.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?, position: Int, id: Long
            ) {
                when (sortList[position]) {
                    "All" -> {

                    }

                    "Available" -> {

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
    }

    // Filter products based on the provided text
    fun filter(text: String) {
        val filteredList: MutableList<InventoryModel> = ArrayList()
        for (model in listOfInventories) {
            if (model.name?.lowercase(Locale.ROOT)
                    ?.contains(text.lowercase(Locale.getDefault())) == true
            ) {
                filteredList.add(model)
            }
        }
        inventoryAdapter.setList(filteredList)
    }

}