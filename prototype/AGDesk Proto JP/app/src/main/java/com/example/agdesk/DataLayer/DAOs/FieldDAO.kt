package com.example.agdesk.DataLayer.DAOs

import androidx.core.view.WindowInsetsCompat.Type.InsetsType
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.agdesk.DataLayer.entities.Fields
import com.example.agdesk.DataLayer.entities.sync.FieldSync
import com.example.agdesk.models.FieldsModel

@Dao
interface FieldDAO {
    @Insert
    suspend fun insertFields(vararg fields: Fields)

    @Query("SELECT name, points FROM Fields")
    suspend fun getAllFields(): MutableList<FieldsModel>

    @Insert
    suspend fun insertSync(vararg sync: FieldSync)


}