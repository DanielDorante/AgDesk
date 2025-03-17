package com.example.agdesk.entities

import com.google.android.gms.maps.model.LatLng
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Feilds (
    @PrimaryKey(autoGenerate = true)
    val uid: Int?,
    val name: String,
    val points: MutableList<LatLng>
)
