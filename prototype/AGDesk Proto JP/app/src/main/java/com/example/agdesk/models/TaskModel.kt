package com.example.agdesk.models

import androidx.compose.ui.input.pointer.PointerId
import androidx.room.ColumnInfo
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.agdesk.DataLayer.Converters.DatabaseConverter
import java.util.Date
import java.util.UUID

data class TaskModel (
    @field:TypeConverters(DatabaseConverter::class) var uid: UUID?, //UUID for local use
    @ColumnInfo(name = "taskName") val name: String?,
    @ColumnInfo(name = "description") val desc: String?,
    @ColumnInfo(name = "time_stamp") val timestamp: Int?, //time stamp of task creation
    @ColumnInfo(name = "is_Delete") val del: Boolean?,
    @field:TypeConverters(DatabaseConverter::class) @ColumnInfo(name = "due_Date") val due: Date?,
    @ColumnInfo(name = "expire_Date") val exp: Int?,
    @ColumnInfo(name = "status") val status: Int?, //completion status, 0-5 see below
    @ColumnInfo(name = "priority") val priority: Int?, //See below 0-3
    @ColumnInfo(name = "assigned_To") val assignedId: Int?, //user assigned to task
    @ColumnInfo(name = "assigned_ToName") val assigned: String?, //Name of user assigned
    @ColumnInfo(name = "farm_Id") val farm: Int?, //Id that the task belongs to
    @ColumnInfo(name = "global_Id") val syncid: Int? // for db sync purposes
    )
// from orefox agdesk
//Status
//          (0, "Not Started"),
//        (1, "In Progress"),
//        (2, "Blocked"    ),
//        (3, "Review"     ),
//        (4, "Complete"   ),
//        (5, "Archived"   )

// Priority
//        (0, "Low"   ),
//        (1, "Medium"),
//        (2, "High"  ),
//        (3, "Urgent")
