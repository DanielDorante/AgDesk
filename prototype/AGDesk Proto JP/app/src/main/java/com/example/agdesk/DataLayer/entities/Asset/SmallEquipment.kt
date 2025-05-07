package com.example.agdesk.DataLayer.entities.Asset

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "small_Equipment",
    foreignKeys = [
        ForeignKey(
            entity = Asset::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("uid"),
            onUpdate = ForeignKey.Companion.CASCADE,
            onDelete = ForeignKey.Companion.CASCADE
        )]
)
data class SmallEquipment(
    @PrimaryKey
    @ColumnInfo(name = "uid") val uid: String,
    @ColumnInfo(name = "serial_Number") val serialNo: String?,

    )