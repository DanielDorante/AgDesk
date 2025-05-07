package com.example.agdesk.DataLayer.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.agdesk.DataLayer.entities.InventoryItem
import com.example.agdesk.DataLayer.entities.sync.InventorySync
import com.example.agdesk.models.UIModels.InventoryModel

@Dao
interface InventoryDAO {
    @Query("SELECT * FROM InventoryItem")
    suspend fun getAll(): MutableList<InventoryModel>

    @Insert
    suspend fun Insert(inventoryItem: InventoryItem)

    @Insert
    suspend fun insertSync(vararg sync: InventorySync)

    @Update
    suspend fun updateItem(inventoryItem: InventoryItem)

    @Delete
    suspend fun deleteItem(inventoryItem: InventoryItem)

}