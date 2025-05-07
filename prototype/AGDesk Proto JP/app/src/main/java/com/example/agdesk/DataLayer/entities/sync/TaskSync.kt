package com.example.agdesk.DataLayer.entities.sync
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.agdesk.DataLayer.entities.Task

@Entity(
    tableName = "task_sync",
    foreignKeys = [
        ForeignKey(
            entity = Task::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("uid"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )]
)
data class TaskSync(
    @PrimaryKey
    @ColumnInfo(name = "uid") val uid: String,
    @ColumnInfo(name = "synctimestamp") val synctime: Long,

    )