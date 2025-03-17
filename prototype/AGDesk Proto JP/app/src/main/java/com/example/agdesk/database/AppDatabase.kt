package com.example.agdesk.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.agdesk.DAOs.AssetDAO
import com.example.agdesk.DAOs.FieldDAO
import com.example.agdesk.DAOs.InventoryDAO
import com.example.agdesk.DAOs.TaskDAO
import com.example.agdesk.entities.Asset
import com.example.agdesk.entities.Fields
import com.example.agdesk.entities.InventoryItem
import com.example.agdesk.entities.LargeEquipment
import com.example.agdesk.entities.SmallEquipment
import com.example.agdesk.entities.Task
import com.example.agdesk.entities.Vehicle
import com.example.agdesk.entities.sync.AssetSync
import com.example.agdesk.entities.sync.FieldSync
import com.example.agdesk.entities.sync.InventorySync
import com.example.agdesk.entities.sync.TaskSync

@Database(entities = [Asset::class, AssetSync::class, Vehicle::class, SmallEquipment::class,
                     LargeEquipment::class, Task::class, TaskSync::class, Fields::class, FieldSync::class,
                     InventoryItem::class, InventorySync::class], version = 1)
abstract class AgDeskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDAO
    abstract fun assetDao(): AssetDAO
    abstract fun inventoryDao(): InventoryDAO
    abstract fun fieldDao(): FieldDAO

    companion object {
        @Volatile
        private var INSTANCE: AgDeskDatabase? = null
        fun getDatabase(context: Context): AgDeskDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AgDeskDatabase::class.java,
                    "AgDeskDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}