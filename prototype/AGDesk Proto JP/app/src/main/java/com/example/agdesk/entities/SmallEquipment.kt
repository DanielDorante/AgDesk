package com.example.agdesk.entities
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
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )]
)
data class SmallEquipment(
    @PrimaryKey
    @ColumnInfo(name = "uid") val uid: Int,
    @ColumnInfo(name = "serial_Number") val serialNo: Int,

    )