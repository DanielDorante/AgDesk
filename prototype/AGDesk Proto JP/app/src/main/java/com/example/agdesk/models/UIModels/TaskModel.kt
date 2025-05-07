package com.example.agdesk.models.UIModels

import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.agdesk.DataLayer.Converters.DatabaseConverter
import java.util.Date
import java.util.UUID

//Model to hold data for interaction with the UI layer and ViewModel
@TypeConverters(DatabaseConverter::class)
data class TaskModel (
    var uid: UUID?, //UUID for local use
    @ColumnInfo(name = "taskName") val name: String?,
    @ColumnInfo(name = "description") val desc: String?,
    @ColumnInfo(name = "time_stamp") val timestamp: Date?, //automatically added timestamp when task created
    @ColumnInfo(name = "is_Delete") var del: Boolean?, //soft delete: Not implemented
    @ColumnInfo(name = "due_Date") val due: Date?,
    @ColumnInfo(name = "expire_Date") val exp: Date?,
    @ColumnInfo(name = "status") var status: Int?, //completion status, 0-5 see below
    @ColumnInfo(name = "priority") var priority: Int?, //See below 0-3
    @ColumnInfo(name = "assigned_To") val assignedId: Long?, //user assigned to task
    @ColumnInfo(name = "assigned_ToName") val assigned: String?, //Name associated with user id
    @ColumnInfo(name = "farm_Id") val farm: Long?, //Id that the task belongs to

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
