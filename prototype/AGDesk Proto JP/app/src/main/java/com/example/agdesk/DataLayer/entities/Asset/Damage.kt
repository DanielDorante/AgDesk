package com.example.agdesk.DataLayer.entities.Asset

import androidx.room.ColumnInfo
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
        )


    ]

)
data class Damage(
    @PrimaryKey @ColumnInfo(name = "Damage_Id") val uid: String,
    @ColumnInfo(name = "Global_id") val syncId: Long?,
    @ColumnInfo(name = "Damage_Observed_Date") val damageObservedDate: Long,
    @ColumnInfo(name = "Damage_Occurred_Date") val damageOccurredDate: Long,
    @ColumnInfo(name = "Damage_Type") val damageType: String,
    @ColumnInfo(name = "Damage_Severity") val damageSeverity: String,
    @ColumnInfo(name = "Notes") val notes: String,
    @ColumnInfo(name = "Damage_Image") val damageImage: String?,
    @ColumnInfo(name = "Scheduled_Maintenance_Date") val scheduleMaintenanceDate: Long?,
    @ColumnInfo(name = "Is_Delete") val isDelete: Boolean?,
    @ColumnInfo(name = "Asset_Id") val assetId: String,
)