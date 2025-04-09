package com.example.agdesk.DataLayer.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.agdesk.DataLayer.Converters.DatabaseConverter


@Entity
data class Farm(
    @PrimaryKey @ColumnInfo(name = "FarmID") val id: String,
    @ColumnInfo(name = "Farm_Name") val name: String,
    @ColumnInfo(name = "Farm_Street") val street: String,
    @ColumnInfo(name = "Farm_State") val state: String,
    @ColumnInfo(name = "Farm_PostCode") val postcode: String,
    @ColumnInfo(name = "Farm_bio") val bio: String,
    @ColumnInfo(name = "Farm_Image") val image: String,

    )
