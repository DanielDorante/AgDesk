package com.example.agdesk.DataLayer.entities.Asset

import android.R
import androidx.room.ColumnInfo
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.agdesk.DataLayer.entities.User.Users

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
            entity = Users::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("Lodged_by_id"),
            onUpdate = ForeignKey.Companion.CASCADE,
            onDelete = ForeignKey.Companion.CASCADE
        )
    ]

)
data class Expense(
    @PrimaryKey @ColumnInfo(name = "Expense_id") val uid: String,
    @ColumnInfo(name = "Global_id") val syncId: Int?,
    @ColumnInfo(name = "Cost") val start: Int,
    @ColumnInfo(name = "receipt_Number") val receipt: Int,
    @ColumnInfo(name = "is_Delete") val isDelete: Boolean?,
    @ColumnInfo(name = "Maintenance_Id") val maintenanceId: String,
    @ColumnInfo(name = "Asset_Id") val assetId: String,
    @ColumnInfo(name = "Lodged_by_id") val lodgedById: Int,


)