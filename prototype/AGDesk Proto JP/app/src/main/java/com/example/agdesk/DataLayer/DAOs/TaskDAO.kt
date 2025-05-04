package com.example.agdesk.DataLayer.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.agdesk.DataLayer.entities.Asset.*
import com.example.agdesk.DataLayer.entities.Asset.LargeEquipment
import com.example.agdesk.DataLayer.entities.Asset.SmallEquipment
import com.example.agdesk.DataLayer.entities.Task
import com.example.agdesk.DataLayer.entities.Asset.Vehicle
import com.example.agdesk.DataLayer.entities.sync.AssetSync
import com.example.agdesk.DataLayer.entities.sync.TaskSync
import com.example.agdesk.models.AssetModel
import com.example.agdesk.models.FieldsModel
import com.example.agdesk.models.TaskModel
import com.example.agdesk.DataLayer.entities.User.UserAuth
import com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel
import java.net.IDN

@Dao
interface TaskDAO {
    @Query("SELECT * FROM TASK")
    suspend fun getAll(): MutableList<TaskModel>

    @Query("SELECT * FROM TASK_SYNC INNER JOIN TASK ON TASK.uid = TASK_SYNC.uid")
    suspend fun getOfflineTasks(): MutableList<TaskNetworkModel>

    @Query("SELECT * FROM TASK WHERE due_Date < :timeFrame") //gets all the tasks that have a due date within the time frame
    suspend fun getTimeframe(timeFrame: Int): MutableList<TaskModel>


    @Query("SELECT * FROM Asset WHERE global_Id = :syncId LIMIT 1")
    suspend fun getBySyncId(syncId: Int): Asset?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(vararg task: Task)

    @Insert
    suspend fun insertSync(vararg sync: TaskSync)

    @Query("DELETE FROM task_sync WHERE uid = :delUid")
    suspend fun deleteSync(delUid: String)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM Task WHERE assigned_To = :id")
    suspend fun getUserTasks(id: Int): MutableList<TaskModel>

}