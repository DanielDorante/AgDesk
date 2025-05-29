package com.example.agdesk.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agdesk.models.UIModels.InventoryModel
import com.example.agdesk.DomainLayer.repository.InventoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class InventoryViewModel @Inject constructor(private val inventoryRepository: InventoryRepository): ViewModel() {

    private val _items = MutableStateFlow<List<InventoryModel>>(emptyList())
    //state held here ready for collectors
    val items: StateFlow<List<InventoryModel>> = _items.asStateFlow()

    init {
        loadItems()
    }

    //Saves an item to the database and refreshes the state post creation
    fun insertItems(inventoryModel: InventoryModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) { //Executing jobs on the InputOutput Thread, good for database interaction
            inventoryRepository.insertInventoryItem(inventoryModel)
            loadItems()
        }
    }

    //Updates an existing inventory item in the database and refreshes the state
    fun updateItem(inventoryModel: InventoryModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            inventoryRepository.updateInventoryItem(inventoryModel)
            loadItems()
        }
    }

    //Deletes an inventory item from the database and refreshes the state
    fun deleteItem(inventoryModel: InventoryModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            inventoryRepository.deleteInventoryItem(inventoryModel)
            loadItems()
        }
    }

    //Updates state with a list of inventory models
    fun loadItems() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val itemList = inventoryRepository.getAllItems()
            _items.value = itemList // Update the StateFlow
        }

    }

}