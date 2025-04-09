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
            childColumns = arrayOf("uid"),
            onUpdate = ForeignKey.Companion.CASCADE,
            onDelete = ForeignKey.Companion.CASCADE
        )
    ]

)
data class Damage(
    @PrimaryKey @ColumnInfo(name = "Damage_Id") val uid: String,
    @ColumnInfo(name = "Global_id") val syncId: Int?,
    @ColumnInfo(name = "Damage_Observed_Date") val damageObservedDate: String,
    @ColumnInfo(name = "Damage_Occurred_Date") val damageOccurredDate: String,
    @ColumnInfo(name = "Damage_Type") val damageType: String,
    @ColumnInfo(name = "Damage_Severity") val damageSeverity: String,
    @ColumnInfo(name = "Notes") val notes: String,
    @ColumnInfo(name = "Damage_Image") val damageImage: String?,
    @ColumnInfo(name = "Scheduled_Maintenance_Date") val scheduleMaintenanceDate: Int?,
    @ColumnInfo(name = "Is_Delete") val isDelete: Boolean?,
    @ColumnInfo(name = "Asset_Id") val assetId: String,
)