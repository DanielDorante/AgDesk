package com.example.agdesk.DataLayer.entities.Asset

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Vehicles",
    foreignKeys = [
        ForeignKey(
            entity = Asset::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("uid"),
            onUpdate = ForeignKey.Companion.CASCADE,
            onDelete = ForeignKey.Companion.CASCADE
        )]
)
data class Vehicle(
    @PrimaryKey
    @ColumnInfo(name = "uid") val uid: String,
    @ColumnInfo(name = "vin") val vin: String?,
    @ColumnInfo(name = "registration") val reg: String?,

    )