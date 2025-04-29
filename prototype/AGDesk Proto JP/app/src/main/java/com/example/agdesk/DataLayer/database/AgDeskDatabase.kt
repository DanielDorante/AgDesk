package com.example.agdesk.DataLayer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.agdesk.DataLayer.DAOs.AssetDAO
import com.example.agdesk.DataLayer.DAOs.FieldDAO
import com.example.agdesk.DataLayer.DAOs.InventoryDAO
import com.example.agdesk.DataLayer.DAOs.TaskDAO
import com.example.agdesk.DataLayer.entities.Asset.*
import com.example.agdesk.DataLayer.entities.Fields
import com.example.agdesk.DataLayer.entities.InventoryItem
import com.example.agdesk.DataLayer.entities.Asset.LargeEquipment
import com.example.agdesk.DataLayer.entities.Asset.SmallEquipment
import com.example.agdesk.DataLayer.entities.Task
import com.example.agdesk.DataLayer.entities.Asset.Vehicle
import com.example.agdesk.DataLayer.entities.User.UserAuth
import com.example.agdesk.DataLayer.entities.User.Users
import com.example.agdesk.DataLayer.entities.sync.AssetSync
import com.example.agdesk.DataLayer.entities.sync.FieldSync
import com.example.agdesk.DataLayer.entities.sync.InventorySync
import com.example.agdesk.DataLayer.entities.sync.TaskSync

@Database(entities = [Asset::class, AssetSync::class, Operations::class, Damage::class, Expense::class, Vehicle::class, SmallEquipment::class,
                     LargeEquipment::class, Task::class, TaskSync::class, Fields::class, FieldSync::class,
                     InventoryItem::class, InventorySync::class, Users::class, UserAuth::class ], version = 3)
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