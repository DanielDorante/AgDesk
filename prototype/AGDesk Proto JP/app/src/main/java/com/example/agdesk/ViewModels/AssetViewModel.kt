package com.example.agdesk.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agdesk.models.AssetModel
import com.example.agdesk.models.FieldsModel
import com.example.agdesk.repository.AssetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class AssetViewModel @Inject constructor(private val assetRepository: AssetRepository): ViewModel() {

    private val _assets = MutableStateFlow<List<AssetModel>>(emptyList())
    val assets: StateFlow<List<AssetModel>> = _assets.asStateFlow()

    init {
        loadAssets()
    }

    fun insertAsssets(vararg assetModel: AssetModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            assetRepository.insertAsset(*assetModel)
            loadAssets()
        }
    }


    fun loadAssets() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val assetList = assetRepository.getAllAssets()
            _assets.value = assetList // Update the StateFlow
        }

    }

    fun loadVehicleAssets() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val assetList = assetRepository.getAllVehicles()
            _assets.value = assetList // Update the StateFlow
        }

    }

    fun loadSmallAssets() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val assetList = assetRepository.getAllSmallEquipment()
            _assets.value = assetList // Update the StateFlow
        }

    }

    fun loadLargeAssets() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val assetList = assetRepository.getAllLargeEquipment()
            _assets.value = assetList // Update the StateFlow
        }

    }

    fun updateAssset(assetModel: AssetModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            assetRepository.updateAsset(assetModel)
            loadAssets()
        }
    }



}