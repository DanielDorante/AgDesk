package com.example.agdesk.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class FarmModel(
    @PrimaryKey @ColumnInfo(name = "FarmID") val id: String,
    @ColumnInfo(name = "Farm_Name") val name: String,
    @ColumnInfo(name = "Farm_Street") val street: String,
    @ColumnInfo(name = "Farm_State") val state: String,
    @ColumnInfo(name = "Farm_PostCode") val postcode: String,
    @ColumnInfo(name = "Farm_bio") val bio: String,
    @ColumnInfo(name = "Farm_Image") val image: String,

    )
