package com.example.agdesk.DataLayer.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.agdesk.DataLayer.entities.Asset.*
import com.example.agdesk.DataLayer.entities.Asset.LargeEquipment
import com.example.agdesk.DataLayer.entities.Asset.SmallEquipment
import com.example.agdesk.DataLayer.entities.Asset.Vehicle

import com.example.agdesk.DataLayer.entities.sync.AssetSync
import com.example.agdesk.models.AssetModel

@Dao
interface AssetDAO {
    @Query("SELECT * FROM Asset")
    fun getAll(): MutableList<AssetModel>

    @Query("SELECT * FROM Asset INNER JOIN Large_Equipment ON Asset.uid = Large_Equipment.uid;")
    fun getAllLargeEquipment(): MutableList<AssetModel>

    @Query("SELECT * FROM Asset INNER JOIN small_Equipment ON Asset.uid = small_Equipment.uid;")
    fun getAllSmallEquipment(): MutableList<AssetModel>

    @Query("SELECT * FROM Asset INNER JOIN Vehicles ON Asset.uid = Vehicles.uid;")
    fun getAllVehicles(): MutableList<AssetModel>

    @Insert
    suspend fun insertAsset(vararg asset: Asset)

    @Insert
    suspend fun insertSync(vararg sync: AssetSync)

    @Insert
    suspend fun insertVehicle(vararg vehicle: Vehicle)

    @Insert
    suspend fun insertSmallEquipment(vararg smallEquipment: SmallEquipment)

    @Insert
    suspend fun insertLargeEquipment(vararg largeEquipment: LargeEquipment)

    @Update
    suspend fun updateAsset(asset: Asset)

    @Delete
    suspend fun deleteAsset(asset: Asset)

}

