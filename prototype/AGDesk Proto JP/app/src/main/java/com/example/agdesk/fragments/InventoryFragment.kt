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
import com.example.agdesk.ViewModels.TaskViewModel
import com.example.agdesk.adapters.TasksAdapter
import com.example.agdesk.databinding.FragmentInventoryBinding
import com.example.agdesk.models.HelperClass
import com.example.agdesk.models.InventoryModel
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

        // Initialize views in the dialog
        val etName = dialogView.findViewById<EditText>(R.id.etName)
        val etQuantity = dialogView.findViewById<EditText>(R.id.etQuantity)
        val btnAddNow = dialogView.findViewById<MaterialButton>(R.id.btnAddNow)
        val btnCancel = dialogView.findViewById<MaterialButton>(R.id.btnCancel)

        btnAddNow.setOnClickListener {
            val name = etName.text.toString().trim()
            val quantity = etQuantity.text.toString().trim()

            if (name.isNotEmpty() && quantity.isNotEmpty()) {
                lifecycleScope.launch {
                    withContext(Dispatchers.Default) {
                        val inventoryItem = InventoryModel(null, name = name,null,null, quantity, null, null, null, null)
                        inventoryViewModel.insertItems(inventoryItem)
                        dialog.dismiss()



                        }
                    }
                Toast.makeText(requireContext(), "Inventory added successfully", Toast.LENGTH_SHORT).show()




            } else {
                Toast.makeText(requireContext(), "Please enter both name and quantity", Toast.LENGTH_SHORT).show()
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