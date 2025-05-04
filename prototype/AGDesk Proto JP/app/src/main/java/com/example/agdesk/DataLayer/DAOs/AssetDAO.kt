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
import com.example.agdesk.models.AssetModel
import com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel

@Dao
interface AssetDAO {
    @Query("SELECT * FROM Asset")
    fun getAll(): MutableList<AssetModel>

    @Query("""SELECT * FROM ASSET_SYNC INNER JOIN Asset ON asset_sync.uid = Asset.uid
            INNER JOIN Large_Equipment ON asset_sync.uid = Large_Equipment.uid
            INNER JOIN small_Equipment ON asset_sync.uid = small_Equipment.uid
            INNER JOIN Vehicles ON asset_sync.uid = Vehicles.uid""")
    fun getOfflineAssets(): MutableList<AssetNetworkModel>



    @Query("SELECT * FROM Asset WHERE global_Id = :syncId LIMIT 1")
    suspend fun getBySyncId(syncId: Int): Asset?

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

