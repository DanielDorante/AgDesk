package com.example.agdesk.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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
    @ColumnInfo(name = "uid") val uid: Int,
    @ColumnInfo(name = "synctimestamp") val synctime: Int,

    )