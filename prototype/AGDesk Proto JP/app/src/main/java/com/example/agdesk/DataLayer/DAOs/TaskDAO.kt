package com.example.agdesk.DataLayer.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
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

@Dao
interface TaskDAO {
    @Query("SELECT * FROM TASK")
    suspend fun getAll(): MutableList<TaskModel>

    @Insert
    suspend fun insertTask(vararg task: Task)

    @Insert
    suspend fun insertSync(vararg sync: TaskSync)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

}