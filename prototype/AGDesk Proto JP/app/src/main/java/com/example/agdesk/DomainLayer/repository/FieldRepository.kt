package com.example.agdesk.DomainLayer.repository

import androidx.annotation.WorkerThread
import com.example.agdesk.DataLayer.DAOs.FieldDAO
import com.example.agdesk.DataLayer.entities.Fields
import com.example.agdesk.DataLayer.entities.sync.FieldSync
import com.example.agdesk.models.UIModels.FieldsModel
import java.util.UUID
import javax.inject.Inject

class FieldRepository @Inject constructor(private val fieldDAO: FieldDAO) {
    @WorkerThread
    suspend fun insertFields(vararg fieldsModel: FieldsModel) {
         fieldsModel.forEach { e ->
             val uuid = UUID.randomUUID()
             val field = Fields(uuid.toString(), e.name, e.points, null)
             val fieldOffline = FieldSync(uuid.toString(), System.currentTimeMillis())
             fieldDAO.insertFields(field)
             fieldDAO.insertSync(fieldOffline)
         }

    }
    @WorkerThread
    suspend fun getAllFields(): MutableList<FieldsModel> {
        return  fieldDAO.getAllFields()
    }




}