package com.example.agdesk.repository

import android.util.Log
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

//Repository used to separate logic from datasource/DAO
class AssetRepository @Inject constructor(private val assetDAO: AssetDAO) {
    @WorkerThread
    suspend fun insertAsset(vararg assetModel: AssetModel) {
        assetModel.forEach { e ->

            //If the uuid is not null then it isn't a new asset and should be using update instead
            //Both the local user and the network will not be creating a UUID for the resource
            //Creating and assigning the UUID here works well to link all the entities by the uuid upon creation
            if (e.uid != null) {
                Log.d("InsertAsset", "InsertFailed: id already initialised, refer to update instead")
                return@forEach
            }

            //generating UUID for local db, because this id is used both as the primary key and foreign key
            //for the child tables. Autogenerate an int would be a pain to link it seems.
            //cons for UUID is primarily storage, as the primary keys are indexed so query speed should be no issue
            val uuid = UUID.randomUUID().toString()
            val asset = Asset(uuid, e.assetPrefix, e.name, e.manufac, e.parts, e.location, e.dateMade, e.dateBuy, false, e.image,e.farmId, e.syncId)
            //When coming from the user the syncId SHOULD be null, when coming from the network sync it should be known.
            if (e.syncId == null) {
                val assetOffline = AssetSync(uuid, System.currentTimeMillis().toString())
                assetDAO.insertSync(assetOffline)
            }

            assetDAO.insertAsset(asset)
            //creation of child table based on prefix.
            when(e.assetPrefix) {
                "LV" -> assetDAO.insertVehicle(Vehicle(uuid,e.vin, e.reg))
                "HV" -> assetDAO.insertVehicle(Vehicle(uuid,e.vin, e.reg))
                "SE" -> assetDAO.insertSmallEquipment(SmallEquipment(uuid,e.serialNo))
                "HE" -> assetDAO.insertLargeEquipment(LargeEquipment(uuid,e.vin))
                null -> return
                else -> return
            }
        }

    }

    suspend fun getAllAssets(): MutableList<AssetModel> {
        return  assetDAO.getAll()
    }
    //get all LV assets
    suspend fun getAllVehicles(): MutableList<AssetModel> {
        return  assetDAO.getAllVehicles()
    }
    //get all LE assets
    suspend fun getAllLargeEquipment(): MutableList<AssetModel> {
        return  assetDAO.getAllLargeEquipment()
    }
    //get all SE assets
    suspend fun getAllSmallEquipment(): MutableList<AssetModel> {
        return  assetDAO.getAllSmallEquipment()
    }

    @WorkerThread
    suspend fun updateAsset(assetModel: AssetModel) {
        // if the id is null the value hasn't been initalised
        //possible revision for network sync????
        if (assetModel.uid == null) {
            Log.d("UpdateAsset", "UpdateFailed: uid is null, cannot locate local asset")
            return
        }
        val assetOffline = AssetSync(assetModel.uid.toString(), System.currentTimeMillis().toString())
        assetDAO.updateAsset(Asset(assetModel.uid.toString(), assetModel.assetPrefix, assetModel.name, assetModel.manufac, assetModel.parts, assetModel.location, assetModel.dateMade, assetModel.dateBuy, false, assetModel.image,assetModel.farmId, assetModel.syncId))
        assetDAO.insertSync(assetOffline)
    }




}