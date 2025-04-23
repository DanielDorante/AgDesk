package com.example.agdesk.DataLayer.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.agdesk.DataLayer.entities.Asset.Asset
import com.example.agdesk.DataLayer.entities.User.Users


@Entity(
    tableName = "Task",
    foreignKeys = [
        ForeignKey(
            entity = Users::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("assigned_To"),
            onUpdate = ForeignKey.Companion.CASCADE,
            onDelete = ForeignKey.Companion.SET_NULL
        )]
)
data class Task(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "taskName") val name: String?,
    @ColumnInfo(name = "description") val desc: String?,
    @ColumnInfo(name = "time_stamp") val timestamp: Int?,
    @ColumnInfo(name = "is_Delete") val del: Boolean?,
    @ColumnInfo(name = "due_Date") val due: Int?,
    @ColumnInfo(name = "expire_Date") val exp: Int?,
    @ColumnInfo(name = "status") val status: Int?,
    @ColumnInfo(name = "priority") val priority: Int?,
    @ColumnInfo(name = "assigned_To") val assigned: Int?,
    @ColumnInfo(name = "farm_Id") val farm: Int?,
    @ColumnInfo(name = "global_Id") val syncid: Int?,

)