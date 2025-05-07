package com.example.agdesk.DataLayer.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.agdesk.DataLayer.entities.Asset.*
import com.example.agdesk.DataLayer.entities.Asset.LargeEquipment
import com.example.agdesk.DataLayer.entities.Asset.SmallEquipment
import com.example.agdesk.DataLayer.entities.Asset.Vehicle


import com.example.agdesk.DataLayer.entities.sync.AssetSync
import com.example.agdesk.models.UIModels.AssetModel
import com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel
import io.ktor.util.StringValuesImpl

@Dao
interface AssetDAO {
    @Query("SELECT * FROM Asset")
    fun getAll(): MutableList<AssetModel>

    @Query("""
    SELECT 
        asset_sync.uid AS uid,
        Asset.asset_Prefix,
        Asset.asset_Name,
        Asset.manufacture,
        Asset.part_List,
        Asset.location,
        Asset.date_Manufactured,
        Asset.date_Purchased,
        Asset.asset_Image,
        Asset.farm_Id,
        Asset.global_Id,
        asset_sync.synctimestamp,
        Large_Equipment.vin AS largeEquipmentVin,  -- Alias for the vin from Large_Equipment
        small_Equipment.serial_Number,
        Vehicles.vin AS vehicleVin,  -- Alias for the vin from Vehicles
        Vehicles.registration
    FROM ASSET_SYNC 
    INNER JOIN Asset ON asset_sync.uid = Asset.uid
    LEFT JOIN Large_Equipment ON asset_sync.uid = Large_Equipment.uid
    LEFT JOIN small_Equipment ON asset_sync.uid = small_Equipment.uid
    LEFT JOIN Vehicles ON asset_sync.uid = Vehicles.uid
""")
    fun getOfflineAssets(): MutableList<AssetNetworkModel>



    @Query("SELECT * FROM Asset WHERE global_Id = :syncId LIMIT 1")
    suspend fun getBySyncId(syncId: Long): Asset?

    @Query("SELECT * FROM Asset WHERE uid = :uid LIMIT 1")
    suspend fun getByUid(uid: String): Asset?

    @Query("SELECT * FROM Asset INNER JOIN Large_Equipment ON Asset.uid = Large_Equipment.uid;")
    fun getAllLargeEquipment(): MutableList<AssetModel>

    @Query("SELECT * FROM Asset INNER JOIN small_Equipment ON Asset.uid = small_Equipment.uid;")
    fun getAllSmallEquipment(): MutableList<AssetModel>

    @Query("SELECT * FROM Asset INNER JOIN Vehicles ON Asset.uid = Vehicles.uid;")
    fun getAllVehicles(): MutableList<AssetModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsset(vararg asset: Asset)

    @Insert
    suspend fun insertSync(vararg sync: AssetSync)

    @Query("DELETE FROM ASSET_SYNC WHERE uid = :delUid")
    suspend fun deleteSync(delUid: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVehicle(vararg vehicle: Vehicle)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSmallEquipment(vararg smallEquipment: SmallEquipment)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLargeEquipment(vararg largeEquipment: LargeEquipment)

    @Update
    suspend fun updateAsset(asset: Asset)

    @Delete
    suspend fun deleteAsset(asset: Asset)

    @Query("SELECT * FROM Operations WHERE Asset_Id = :uid AND End_Date_Time IS NULL")
    suspend fun getActiveOperationsByUUid(uid: String): List<Operations>

}

