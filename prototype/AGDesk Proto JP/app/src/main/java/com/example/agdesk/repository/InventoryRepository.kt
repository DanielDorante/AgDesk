package com.example.agdesk.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.agdesk.DataLayer.DAOs.FieldDAO
import com.example.agdesk.DataLayer.DAOs.InventoryDAO
import com.example.agdesk.DataLayer.entities.Asset.Asset
import com.example.agdesk.DataLayer.entities.Asset.LargeEquipment
import com.example.agdesk.DataLayer.entities.Asset.SmallEquipment
import com.example.agdesk.DataLayer.entities.Asset.Vehicle
import com.example.agdesk.DataLayer.entities.InventoryItem
import com.example.agdesk.DataLayer.entities.Supplier
import com.example.agdesk.DataLayer.entities.sync.AssetSync
import com.example.agdesk.DataLayer.entities.sync.InventorySync
import com.example.agdesk.models.InventoryModel

import java.util.UUID
import javax.inject.Inject

class InventoryRepository @Inject constructor(private val inventoryDAO: InventoryDAO) {


    @WorkerThread
    suspend fun getAllItems(): MutableList<InventoryModel> {
        return inventoryDAO.getAll()
    }

    @WorkerThread
    suspend fun insertInventoryItem(inventoryModel: InventoryModel) {
        //If the uuid is not null then it isn't a new asset and should be using update instead
        //Both the local user and the network will not be creating a UUID for the resource
        //Creating and assigning the UUID here works well to link all the entities by the uuid upon creation
        if (inventoryModel.uid != null) {
            Log.d("InsertItem", "InsertFailed: id already initialised, refer to update instead")
            return
        }

        //generating UUID for local db, because this id is used both as the primary key and foreign key
        //for the child tables. Autogenerate an int would be a pain to link it seems.
        //cons for UUID is primarily storage, as the primary keys are indexed so query speed should be no issue
        val uuid = UUID.randomUUID().toString()
        val item = InventoryItem(uuid, inventoryModel.name, inventoryModel.sku, inventoryModel.category, inventoryModel.quantity, inventoryModel.costPrice, inventoryModel.salePrice,
            Supplier(inventoryModel.supplier?.name, inventoryModel.supplier?.email, inventoryModel.supplier?.phone), inventoryModel.syncid)
        //When coming from the user the syncId SHOULD be null, when coming from the network sync it should be known.
        if (item.syncid == null) {
            val itemOffline = InventorySync(uuid, System.currentTimeMillis().toString())
            inventoryDAO.insertSync(itemOffline)
        }

        inventoryDAO.Insert(item)
        //creation of child table based on prefix.


    }






}