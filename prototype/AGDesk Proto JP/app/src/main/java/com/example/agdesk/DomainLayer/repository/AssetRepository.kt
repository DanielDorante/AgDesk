package com.example.agdesk.DomainLayer.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.agdesk.DataLayer.DAOs.AssetDAO
import com.example.agdesk.DataLayer.entities.Asset.*
import com.example.agdesk.DataLayer.entities.Asset.LargeEquipment
import com.example.agdesk.DataLayer.entities.Asset.SmallEquipment
import com.example.agdesk.DataLayer.entities.Asset.Vehicle
import com.example.agdesk.DataLayer.entities.sync.AssetSync
import com.example.agdesk.DomainLayer.mapper.toAssetEntity
import com.example.agdesk.models.UIModels.AssetModel
import com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel

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



            //When coming from the user the syncId SHOULD be null, when coming from the network sync it should be known.

            val asset = e.toAssetEntity(null)
            assetDAO.insertAsset(asset)
            val assetOffline = AssetSync(asset.uid, System.currentTimeMillis())
            assetDAO.insertSync(assetOffline)

            //creation of child table based on prefix.
            when(e.assetPrefix) {
                "LV" -> assetDAO.insertVehicle(Vehicle(asset.uid,e.vin, e.reg))
                "HV" -> assetDAO.insertVehicle(Vehicle(asset.uid,e.vin, e.reg))
                "SE" -> assetDAO.insertSmallEquipment(SmallEquipment(asset.uid,e.serialNo))
                "HE" -> assetDAO.insertLargeEquipment(LargeEquipment(asset.uid,e.vin))
                null -> return
                else -> return
            }
        }

    }

    suspend fun getCheckoutStatus(assets: MutableList<AssetModel>): MutableList<AssetModel> {
        for (model in assets) {
            val operations = assetDAO.getActiveOperationsByUUid(model.uid.toString())
            if (!operations.isEmpty()) {
                model.checkoutStatus = true
                model.checkoutBy = operations[0].userid
            }
        }
        return assets
    }

    suspend fun getAllAssets(): MutableList<AssetModel> {
        return  getCheckoutStatus(assetDAO.getAll())
    }


    //get all LV assets
    suspend fun getAllVehicles(): MutableList<AssetModel> {
        return  getCheckoutStatus(assetDAO.getAllVehicles())
    }
    //get all LE assets
    suspend fun getAllLargeEquipment(): MutableList<AssetModel> {
        return  getCheckoutStatus(assetDAO.getAllLargeEquipment())
    }
    //get all SE assets
    suspend fun getAllSmallEquipment(): MutableList<AssetModel> {
        return  getCheckoutStatus(assetDAO.getAllSmallEquipment())
    }

    @WorkerThread
    suspend fun updateAsset(assetModel: AssetModel) {
        // if the id is null the value hasn't been initalised

        if (assetModel.uid == null) {
            Log.d("UpdateAsset", "UpdateFailed: uid is null, cannot locate local asset")
            return
        }

        //Because the UI model doesn't know its sync id we inject it here so the local update dosen't set syncId to null
        val asset = assetModel.toAssetEntity(assetDAO.getByUid(assetModel.uid.toString()))
        assetDAO.updateAsset(asset)

        val assetOffline = AssetSync(asset.uid.toString(), System.currentTimeMillis())
        assetDAO.insertSync(assetOffline)
    }


    @WorkerThread
    suspend fun updateAssetNetwork(assetNetworkModel: List<AssetNetworkModel>) {
        for (networkAsset in assetNetworkModel) {
            if (networkAsset.syncId == null) continue // can't process without sync ID

            val resolvedUid = networkAsset.uid?.toString()
                ?: assetDAO.getBySyncId(networkAsset.syncId)?.uid
                ?: UUID.randomUUID().toString()


            val asset = Asset(
                uid = resolvedUid,
                assetPrefix = networkAsset.assetPrefix,
                name = networkAsset.name,
                manufac = networkAsset.manufac,
                parts = networkAsset.parts,
                location = networkAsset.location,
                dateMade = networkAsset.dateMade,
                dateBuy = networkAsset.dateBuy,
                isDel = false,
                image = networkAsset.image,
                farmId = networkAsset.farmId,
                syncId = networkAsset.syncId
            )

            assetDAO.insertAsset(asset) // REPLACE ensures update/insert both work

            when(networkAsset.assetPrefix) {
                "LV" -> assetDAO.insertVehicle(Vehicle(asset.uid,networkAsset.vehicleVin, networkAsset.reg))
                "HV" -> assetDAO.insertVehicle(Vehicle(asset.uid,networkAsset.vehicleVin, networkAsset.reg))
                "SE" -> assetDAO.insertSmallEquipment(SmallEquipment(asset.uid,networkAsset.serialNo))
                "HE" -> assetDAO.insertLargeEquipment(LargeEquipment(asset.uid,networkAsset.largeEquipmentVin))
                null -> continue
                else -> continue
            }
            assetDAO.deleteSync(asset.uid)

        }
    }


    suspend fun getOfflineAssets(): List<AssetNetworkModel> {
        return  assetDAO.getOfflineAssets()
    }






}