package com.example.agdesk.DAOs

import androidx.room.Dao
import androidx.room.Query
import com.example.agdesk.entities.Asset
import com.example.agdesk.entities.sync.AssetSync

@Dao
interface AssetDAO {
    @Query("SELECT * FROM Asset")
    fun getAll(): List<Asset>
}

