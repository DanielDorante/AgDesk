package com.example.agdesk.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.agdesk.DataLayer.DAOs.TaskDAO
import com.example.agdesk.DataLayer.entities.Asset
import com.example.agdesk.DataLayer.entities.Asset.LargeEquipment
import com.example.agdesk.DataLayer.entities.Asset.SmallEquipment
import com.example.agdesk.DataLayer.entities.Task
import com.example.agdesk.DataLayer.entities.Asset.Vehicle
import com.example.agdesk.DataLayer.entities.sync.AssetSync
import com.example.agdesk.DataLayer.entities.sync.TaskSync
import com.example.agdesk.models.AssetModel
import com.example.agdesk.models.TaskModel
import java.util.UUID
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskDAO: TaskDAO){
    @WorkerThread
    suspend fun insertTask(vararg taskModel: TaskModel) {
        taskModel.forEach { e ->

            //If the uuid is not null then it isn't a new asset and should be using update instead
            //Both the local user and the network will not be creating a UUID for the resource
            //Creating and assigning the UUID here works well to link all the entities by the uuid upon creation
            if (e.uid != null) {
                Log.d("InsertTask", "InsertFailed: id already initialised, refer to update instead")
                return@forEach
            }

            //generating UUID for local db, because this id is used both as the primary key and foreign key
            //for the child tables. Autogenerate an int would be a pain to link it seems.
            //cons for UUID is primarily storage, as the primary keys are indexed so query speed should be no issue
            val uuid = UUID.randomUUID().toString()
            val task = Task(uuid, e.name, e.desc, e.timestamp, false, e.due, e.exp, e.status, e.priority, e.assigned, e.farm, e.syncid)
            //When coming from the user the syncId SHOULD be null, when coming from the network sync it should be known.
            if (e.syncid == null) {
                val taskOffline = TaskSync(uuid, System.currentTimeMillis().toString())
                taskDAO.insertSync(taskOffline)
            }

            taskDAO.insertTask(task)

        }

    }

    suspend fun getAllTasks(): MutableList<TaskModel> {
        return  taskDAO.getAll()
    }


    @WorkerThread
    suspend fun updateTask(taskModel: TaskModel) {
        // if the id is null the value hasn't been initalised
        //possible revision for network sync????
        if (taskModel.uid == null) {
            Log.d("UpdateTask", "UpdateFailed: uid is null, cannot locate local asset")
            return
        }
        val taskOffline = TaskSync(taskModel.uid.toString(), System.currentTimeMillis().toString())
        taskDAO.updateTask(Task(taskModel.uid.toString(),  taskModel.name, taskModel.desc, taskModel.timestamp, false, taskModel.due, taskModel.exp, taskModel.status, taskModel.priority, taskModel.assigned, taskModel.farm, taskModel.syncid))
        taskDAO.insertSync(taskOffline)
    }
}