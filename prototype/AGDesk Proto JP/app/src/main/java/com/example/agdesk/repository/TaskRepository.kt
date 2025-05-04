package com.example.agdesk.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.agdesk.DataLayer.DAOs.TaskDAO
import com.example.agdesk.DataLayer.DAOs.UserDAO
import com.example.agdesk.DataLayer.entities.Asset.*
import com.example.agdesk.DataLayer.entities.Asset.LargeEquipment
import com.example.agdesk.DataLayer.entities.Asset.SmallEquipment
import com.example.agdesk.DataLayer.entities.Task
import com.example.agdesk.DataLayer.entities.Asset.Vehicle
import com.example.agdesk.DataLayer.entities.sync.AssetSync
import com.example.agdesk.DataLayer.entities.sync.TaskSync
import com.example.agdesk.models.AssetModel
import com.example.agdesk.models.TaskModel
import com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel
import java.util.UUID
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskDAO: TaskDAO, private val userDAO: UserDAO){
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
            val task = Task(uuid, e.name, e.desc, e.timestamp, false, e.due, e.exp, e.status, e.priority, e.assignedId, e.farm, e.syncid)
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

    suspend fun getTasksByTimeFrame(timeFrame: String): MutableList<TaskModel> {

        val list: MutableList<TaskModel>
        when(timeFrame) {
            "Month" -> {
                val unixTimeParameter: Int = (System.currentTimeMillis() + 2629800000).toInt()
                list = taskDAO.getTimeframe(unixTimeParameter)
            }

            "Week" -> {
                val unixTimeParameter: Int = (System.currentTimeMillis() + 604800000).toInt()
                list = taskDAO.getTimeframe(unixTimeParameter)
            }

            else -> {
                list = taskDAO.getAll() // have to initialise everything
                list.clear() // return empty list
            }

        }

        return list
    }

    suspend fun getThisUsersTasks(): MutableList<TaskModel> {
        val id = userDAO.getCurrentUser()
        return  taskDAO.getUserTasks(id)
    }


    @WorkerThread
    suspend fun updateTask(taskModel: TaskModel) { //Expects an existing task model with valid id
        // if the id is null the value hasn't been initialised
        //possible revision for network sync????
        if (taskModel.uid == null) {
            Log.d("UpdateTask", "UpdateFailed: uid is null, cannot locate local asset")
            return
        }
        val taskOffline = TaskSync(taskModel.uid.toString(), System.currentTimeMillis().toString())
        taskDAO.updateTask(Task(taskModel.uid.toString(),  taskModel.name, taskModel.desc, taskModel.timestamp, false, taskModel.due, taskModel.exp, taskModel.status, taskModel.priority, taskModel.assignedId, taskModel.farm, taskModel.syncid))
        taskDAO.insertSync(taskOffline)
    }


    @WorkerThread
    suspend fun updateTaskNetwork(taskNetworkModel: List<TaskNetworkModel>) {
        for (networkTask in taskNetworkModel) {
            if (networkTask.syncid == null) continue

            val resolvedUid = networkTask.uid?.toString()
                ?: taskDAO.getBySyncId(networkTask.syncid)?.uid
                ?: UUID.randomUUID().toString()


            val task = Task(
                uid = resolvedUid,
                name = networkTask.name,
                desc = networkTask.desc,
                timestamp = networkTask.timestamp,
                del = networkTask.del,
                due = networkTask.due,
                exp = networkTask.exp,
                status = networkTask.status,
                priority = networkTask.priority,
                assigned = networkTask.assignedId,
                farm = networkTask.farm,
                syncid = networkTask.syncid
            )

            taskDAO.insertTask(task)
            taskDAO.deleteSync(task.uid)

        }
    }

    suspend fun getOfflineTasks(): List<TaskNetworkModel> {
        return  taskDAO.getOfflineTasks()
    }
}