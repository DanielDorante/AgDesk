package com.example.agdesk.DataLayer.entities.sync
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.agdesk.DataLayer.entities.Fields

@Entity(
    tableName = "Field_Sync",
    foreignKeys = [
        ForeignKey(
            entity = Fields::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("uid"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )]
)
data class FieldSync(
    @PrimaryKey
    @ColumnInfo(name = "uid") val uid: String,
    @ColumnInfo(name = "synctimestamp") val synctime: Long,

    )