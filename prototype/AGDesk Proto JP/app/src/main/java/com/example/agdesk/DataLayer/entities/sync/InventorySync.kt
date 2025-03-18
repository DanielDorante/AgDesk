package com.example.agdesk.DataLayer.entities.sync
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.agdesk.DataLayer.entities.InventoryItem

@Entity(
    tableName = "inventory_Sync",
    foreignKeys = [
        ForeignKey(
            entity = InventoryItem::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("uid"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )]
)
data class InventorySync(
    @PrimaryKey
    @ColumnInfo(name = "uid") val uid: Int,
    @ColumnInfo(name = "synctimestamp") val synctime: Int,

    )