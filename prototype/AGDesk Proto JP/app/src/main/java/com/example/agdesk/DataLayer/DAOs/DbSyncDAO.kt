package com.example.agdesk.DataLayer.DAOs



import com.example.agdesk.models.networkModels.SyncRequest
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.agdesk.DataLayer.entities.sync.DbSync

@Dao
interface DbSyncDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSyncInfo(dbSync: DbSync)

    @Query("SELECT * FROM DbSync WHERE dbInfoId = 1")
    suspend fun getLastSyncInfo(): SyncRequest?

    @Query("UPDATE DbSync SET lastSyncTimeStamp = :timestamp WHERE dbInfoId = 1")
    suspend fun updateSyncTimestamp(timestamp: String) // Or Long depending on your format
}

