package com.example.agdesk.DataLayer.entities.sync

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbSync(
    @PrimaryKey
    @ColumnInfo(name = "dbInfoId") val id: Int = 1,
    @ColumnInfo(name = "lastSyncTimeStamp") val synctime: Long,


    )
