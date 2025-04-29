package com.example.agdesk.DataLayer.entities.Asset

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey( //link asset and operations together by asset id
            entity = Asset::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("Asset_Id"),
            onUpdate = ForeignKey.Companion.CASCADE,
            onDelete = ForeignKey.Companion.CASCADE
        ),

        ForeignKey( // TO DO: implement userid and tie it to operation
            entity = Asset::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("Asset_Id"),
            onUpdate = ForeignKey.Companion.CASCADE,
            onDelete = ForeignKey.Companion.CASCADE
        )
    ]

)
data class Operations(
    @PrimaryKey @ColumnInfo(name = "Log_id") val uid: String,
    @ColumnInfo(name = "Global_id") val syncId: Int?,
    @ColumnInfo(name = "Start_Date_Time") val start: String,
    @ColumnInfo(name = "End_Date_Time") val end: String?,
    @ColumnInfo(name = "Location") val location: String,
    @ColumnInfo(name = "Notes") val notes: String?,
    @ColumnInfo(name = "isDelete") val isDelete: Boolean,
    @ColumnInfo(name = "Asset_Id") val assetUid: String,
    @ColumnInfo(name = "User_ID") val userid: String,
)