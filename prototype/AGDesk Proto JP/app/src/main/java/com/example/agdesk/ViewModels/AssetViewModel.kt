package com.example.agdesk.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agdesk.DomainLayer.mapper.toAssetEntity
import com.example.agdesk.models.UIModels.AssetModel
import com.example.agdesk.DomainLayer.repository.AssetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject



//ViewModel for persisting state to the UI through configuration changes(rotate screen ect)
//Also handles concurrency scope and thread for coroutines, Stops the Room Calls being called from Main
@HiltViewModel
class AssetViewModel @Inject constructor(private val assetRepository: AssetRepository): ViewModel() {

    private val _assets = MutableStateFlow<List<AssetModel>>(emptyList())
    //state held here ready for collectors
    val assets: StateFlow<List<AssetModel>> = _assets.asStateFlow()

    init {
        loadAssets()
    }

    //Saves an Asset to the database and refreshes the state post creation
    fun insertAsssets(vararg assetModel: AssetModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) { //Executing jobs on the InputOutput Thread, good for database interaction
            assetRepository.insertAsset(*assetModel)
            loadAssets()
        }
    }

    //Updates the state with a list of all Assets in the db
    fun loadAssets() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val assetList = assetRepository.getAllAssets()
            _assets.value = assetList // Update the StateFlow
        }

    }


    //Updates the state with a list of Assets of HV/LV vehicle type
    fun loadVehicleAssets() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val assetList = assetRepository.getAllVehicles()
            _assets.value = assetList // Update the StateFlow
        }

    }
    //Updates the state with a list of Assets of SE Equipment type
    fun loadSmallAssets() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val assetList = assetRepository.getAllSmallEquipment()
            _assets.value = assetList // Update the StateFlow
        }

    }
    //Updates the state with a list of Assets of LE Equipment type
    fun loadLargeAssets() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val assetList = assetRepository.getAllLargeEquipment()
            _assets.value = assetList // Update the StateFlow
        }

    }

    //Updates an Asset via passing a complete AssetModel
    //It will check if the uid matches one in the database
    //Then updates every field in the asset according to the AssetModel passed
    //Note: If you leave something null it will probably overwrite.
    fun updateAsset(assetModel: AssetModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            assetRepository.updateAsset(assetModel)
            loadAssets()
        }
    }

    // Delete an asset
    fun deleteAsset(assetModel: AssetModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            // Convert the AssetModel to an entity using the extension function from the repository
            if (assetModel.uid != null) {
                val existingAsset = assetRepository.assetDAO.getByUid(assetModel.uid.toString())
                if (existingAsset != null) {
                    val asset = assetModel.toAssetEntity(existingAsset)
                    assetRepository.assetDAO.deleteAsset(asset)
                    loadAssets() // Refresh the asset list after deletion
                }
            }
        }
    }
}