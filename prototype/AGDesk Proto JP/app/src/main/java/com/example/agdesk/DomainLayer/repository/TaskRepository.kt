package com.example.agdesk.DomainLayer.repository



import android.util.Log
import androidx.annotation.WorkerThread
import com.example.agdesk.DataLayer.DAOs.TaskDAO
import com.example.agdesk.DataLayer.DAOs.UserDAO
import com.example.agdesk.DataLayer.entities.sync.TaskSync
import com.example.agdesk.models.UIModels.TaskModel
import com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel
import java.util.UUID
import javax.inject.Inject
import com.example.agdesk.DomainLayer.mapper.toEntity

class TaskRepository @Inject constructor(private val taskDAO: TaskDAO, private val userDAO: UserDAO){
    @WorkerThread
    suspend fun insertTask(vararg taskModel: TaskModel) {
        taskModel.forEach { e ->

            //If the uuid is not null then it isn't a new asset and should be using update instead
            //Both the local user and the network will not be creating a UUID for the resource
            //Creating and assigning the UUID here works well to link all the entities by the uuid upon creation
//            if (e.uid != null) {
//                Log.d("InsertTask", "InsertFailed: id already initialised, refer to update instead")
//                return@forEach
//            }

            //generating UUID for local db, because this id is used both as the primary key and foreign key
            //for the child tables. Autogtestenerate an int would be a pain to link it seems.
            //cons for UUID is primarily storage, as the primary keys are indexed so query speed should be no issue

            //e.uid = UUID.randomUUID() /made redundant by mapper


            //When coming from the user the syncId SHOULD be null, when coming from the network sync it should be known.

            val task = e.toEntity(null)
            taskDAO.insertTask(task)

            val taskOffline = TaskSync(task.uid, System.currentTimeMillis())
            taskDAO.insertSync(taskOffline)


        }

    }

    suspend fun getAllTasks(): MutableList<TaskModel> {
        return  taskDAO.getAll()
    }

    suspend fun getTasksByTimeFrame(timeFrame: String): MutableList<TaskModel> {

        val list: MutableList<TaskModel>
        when(timeFrame) {
            "Month" -> {
                val unixTimeParameter: Long = (System.currentTimeMillis() + 2629800000)
                list = taskDAO.getTimeframe(unixTimeParameter)
            }

            "Week" -> {
                val unixTimeParameter: Long = (System.currentTimeMillis() + 604800000)
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

        if (taskModel.uid == null) {
            Log.d("UpdateTask", "UpdateFailed: uid is null, cannot locate local asset")
            return
        }
        val task = taskModel.toEntity(taskDAO.getByUid(taskModel.uid.toString()))
        val taskOffline = TaskSync(task.uid, System.currentTimeMillis())
        taskDAO.updateTask(task)
        taskDAO.insertSync(taskOffline)
    }

    @WorkerThread
    suspend fun deleteTask(task: com.example.agdesk.DataLayer.entities.Task) {
        if (task.uid.isNotEmpty()) {
            try {
                // First delete any sync records for this task
                taskDAO.deleteSync(task.uid)
                // Then delete the task itself
                taskDAO.deleteTask(task)
                Log.d("DeleteTask", "Task deleted successfully, uid: ${task.uid}")
            } catch (e: Exception) {
                Log.e("DeleteTask", "Error deleting task: ${e.message}")
            }
        } else {
            Log.d("DeleteTask", "DeleteFailed: Invalid task uid")
        }
    }

    @WorkerThread
    suspend fun updateTaskNetwork(taskNetworkModel: List<TaskNetworkModel>) {
        for (networkTask in taskNetworkModel) {
            if (networkTask.syncId == null) continue

            val resolvedUid = networkTask.uid?.toString() //Set Uid to that in the response(Used in the SyncToServer())
                ?: taskDAO.getBySyncId(networkTask.syncId)?.uid //Set Uid based on the SyncId(Used in the SyncFromServer())
                ?: UUID.randomUUID().toString()//New Item coming from network, generate new Uid(Used in SyncFromServer())


            //set the networkTask uid so it can be mapped to an entity object
            //if uid resolution isn't done it will create new local task where a preexisting
            //task could have the same sync Id.
            networkTask.uid = resolvedUid
            val task = networkTask.toEntity()


            taskDAO.insertTask(task)
            taskDAO.deleteSync(task.uid)

        }
    }

    suspend fun getOfflineTasks(): List<TaskNetworkModel> {
        return  taskDAO.getOfflineTasks()
    }
}