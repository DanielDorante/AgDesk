package com.example.agdesk.DomainLayer.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.agdesk.DataLayer.DAOs.InventoryDAO
import com.example.agdesk.DataLayer.entities.InventoryItem
import com.example.agdesk.DataLayer.entities.Supplier
import com.example.agdesk.DataLayer.entities.sync.InventorySync
import com.example.agdesk.models.UIModels.InventoryModel

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
            Supplier(inventoryModel.supplier?.name, inventoryModel.supplier?.email, inventoryModel.supplier?.phone), null)
        //When coming from the user the syncId SHOULD be null, when coming from the network sync it should be known.
        inventoryDAO.Insert(item)
        if (item.syncid == null) {
            val itemOffline = InventorySync(uuid, System.currentTimeMillis())
            inventoryDAO.insertSync(itemOffline)
        }


        //creation of child table based on prefix.


    }

    @WorkerThread
    suspend fun updateInventoryItem(inventoryModel: InventoryModel) {
        // Check if the uid is present - required for update
        if (inventoryModel.uid == null) {
            Log.d("UpdateItem", "UpdateFailed: id is null, cannot locate inventory item")
            return
        }

        val item = InventoryItem(
            inventoryModel.uid,
            inventoryModel.name,
            inventoryModel.sku,
            inventoryModel.category,
            inventoryModel.quantity,
            inventoryModel.costPrice,
            inventoryModel.salePrice,
            Supplier(inventoryModel.supplier?.name, inventoryModel.supplier?.email, inventoryModel.supplier?.phone),
            null
        )

        inventoryDAO.updateItem(item)

        // Update the sync record
        try {
            // First delete any existing sync record for this item
            val itemOffline = InventorySync(inventoryModel.uid, System.currentTimeMillis())
            inventoryDAO.insertSync(itemOffline)
        } catch (e: Exception) {
            Log.e("UpdateInventory", "Error updating sync record: ${e.message}")
        }
    }

    @WorkerThread
    suspend fun deleteInventoryItem(inventoryModel: InventoryModel) {
        // Check if the uid is present - required for deletion
        if (inventoryModel.uid == null) {
            Log.d("DeleteItem", "DeleteFailed: id is null, cannot locate inventory item")
            return
        }

        val item = InventoryItem(
            inventoryModel.uid,
            inventoryModel.name,
            inventoryModel.sku,
            inventoryModel.category,
            inventoryModel.quantity,
            inventoryModel.costPrice,
            inventoryModel.salePrice,
            Supplier(inventoryModel.supplier?.name, inventoryModel.supplier?.email, inventoryModel.supplier?.phone),
            null
        )

        inventoryDAO.deleteItem(item)
    }






}