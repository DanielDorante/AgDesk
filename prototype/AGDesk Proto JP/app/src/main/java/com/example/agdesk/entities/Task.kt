package com.example.agdesk.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val uid: Int,
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