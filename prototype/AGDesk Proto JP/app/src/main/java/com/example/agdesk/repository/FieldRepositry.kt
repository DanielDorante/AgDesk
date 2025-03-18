package com.example.agdesk.repository

import androidx.annotation.WorkerThread
import androidx.room.Insert
import androidx.room.Query
import com.example.agdesk.DataLayer.DAOs.FieldDAO
import com.example.agdesk.DataLayer.entities.Fields
import com.example.agdesk.models.FieldsModel
import javax.inject.Inject

class FieldRepositry @Inject constructor(private val fieldDAO: FieldDAO) {
    @WorkerThread
    suspend fun insertFields(vararg fields: Fields) {
         fieldDAO.insertFields(*fields)
    }

    suspend fun getAllFields(): MutableList<FieldsModel> {
        return  fieldDAO.getAllFields()
    }


}