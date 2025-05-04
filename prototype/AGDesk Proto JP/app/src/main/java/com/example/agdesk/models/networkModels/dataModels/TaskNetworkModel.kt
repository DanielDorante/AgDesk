package com.example.agdesk.models.networkModels.dataModels

import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.agdesk.DataLayer.Converters.DatabaseConverter
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class TaskNetworkModel(
    @field:TypeConverters(DatabaseConverter::class) var uid: String?, //UUID for local use
    @ColumnInfo(name = "taskName") val name: String?,
    @ColumnInfo(name = "description") val desc: String?,
    @ColumnInfo(name = "time_stamp") val timestamp: Int?, //time stamp of task creation
    @ColumnInfo(name = "is_Delete") val del: Boolean?,
    @ColumnInfo(name = "due_Date") val due: Int?,
    @ColumnInfo(name = "expire_Date") val exp: Int?,
    @ColumnInfo(name = "status") val status: Int?, //completion status, 0-5 see below
    @ColumnInfo(name = "priority") val priority: Int?, //See below 0-3
    @ColumnInfo(name = "assigned_To") val assignedId: Int?, //user assigned to task
    @ColumnInfo(name = "assigned_ToName") val assigned: String?, //Name of user assigned
    @ColumnInfo(name = "farm_Id") val farm: Int?, //Id that the task belongs to
    @ColumnInfo(name = "global_Id") val syncid: Int? // for db sync purposes

)