package com.example.agdesk.DataLayer.DAOs

import androidx.room.Dao
import androidx.room.Query
import com.example.agdesk.DataLayer.entities.Asset
import com.example.agdesk.DataLayer.entities.sync.AssetSync

@Dao
interface AssetDAO {
    @Query("SELECT * FROM Asset")
    fun getAll(): List<Asset>
}

