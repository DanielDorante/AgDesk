package com.example.agdesk.DataLayer.DAOs

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.agdesk.DataLayer.entities.Farm
import com.example.agdesk.models.UIModels.AssetModel
import com.example.agdesk.models.UIModels.FarmModel


@Dao
interface FarmDAO {
    @Query("SELECT * FROM Farm")
    suspend fun getAll(): MutableList<FarmModel>

    @Insert
    suspend fun Insert(farm: Farm)



}