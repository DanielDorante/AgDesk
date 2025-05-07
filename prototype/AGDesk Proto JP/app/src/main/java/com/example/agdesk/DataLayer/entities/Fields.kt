package com.example.agdesk.DataLayer.entities

import androidx.room.ColumnInfo
import com.google.android.gms.maps.model.LatLng
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.agdesk.DataLayer.Converters.DatabaseConverter


@Entity
data class Fields (
    @PrimaryKey
    @field:TypeConverters(DatabaseConverter::class)
    val uid: String,
    val name: String,
    @field:TypeConverters(DatabaseConverter::class) val points: List<LatLng>,
    @ColumnInfo(name = "global_Id") val syncid: Long?,
)
