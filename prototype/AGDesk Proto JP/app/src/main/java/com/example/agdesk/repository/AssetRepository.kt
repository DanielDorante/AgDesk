package com.example.agdesk.repository

import androidx.annotation.WorkerThread
import com.example.agdesk.DataLayer.DAOs.AssetDAO
import com.example.agdesk.DataLayer.entities.Asset
import com.example.agdesk.DataLayer.entities.LargeEquipment
import com.example.agdesk.DataLayer.entities.SmallEquipment
import com.example.agdesk.DataLayer.entities.Vehicle
import com.example.agdesk.DataLayer.entities.sync.AssetSync
import com.example.agdesk.models.AssetModel
import com.example.agdesk.models.FieldsModel
import java.util.UUID
import javax.inject.Inject

class AssetRepository @Inject constructor(private val assetDAO: AssetDAO) {
    @WorkerThread
    suspend fun insertAsset(vararg assetModel: AssetModel) {
        assetModel.forEach { e ->
            val uuid = UUID.randomUUID().toString()
            val asset = Asset(uuid, e.assetPrefix, e.name, e.manufac, e.parts, e.location, e.dateMade, e.dateBuy, false, e.image,e.farmId, null)
            val assetOffline = AssetSync(uuid, System.currentTimeMillis().toString())
            assetDAO.insertAsset(asset)
            assetDAO.insertSync(assetOffline)
            when(e.assetPrefix) {
                "LV" -> assetDAO.insertVehicle(Vehicle(uuid,e.vin, e.reg))
                "HV" -> assetDAO.insertVehicle(Vehicle(uuid,e.vin, e.reg))
                "SE" -> assetDAO.insertSmallEquipment(SmallEquipment(uuid,e.serialNo))
                "HE" -> assetDAO.insertLargeEquipment(LargeEquipment(uuid,e.vin))
                else -> return
            }
        }

    }

    suspend fun getAllAssets(): MutableList<AssetModel> {
        return  assetDAO.getAll()
    }

    suspend fun getAllVehicles(): MutableList<AssetModel> {
        return  assetDAO.getAllVehicles()
    }

    suspend fun getAllLargeEquipment(): MutableList<AssetModel> {
        return  assetDAO.getAllLargeEquipment()
    }

    suspend fun getAllSmallEquipment(): MutableList<AssetModel> {
        return  assetDAO.getAllSmallEquipment()
    }

    @WorkerThread
    suspend fun updateAsset(assetModel: AssetModel) {
        assetDAO.updateAsset(Asset(assetModel.uid.toString(), assetModel.assetPrefix, assetModel.name, assetModel.manufac, assetModel.parts, assetModel.location, assetModel.dateMade, assetModel.dateBuy, false, assetModel.image,assetModel.farmId, assetModel.syncId))
    }




}