package com.example.agdesk.DataLayer.entities.User

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.agdesk.DataLayer.entities.Asset.Asset

@Entity(
    tableName = "UserAuth",
    foreignKeys = [
        ForeignKey(
            entity = Users::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onUpdate = ForeignKey.Companion.CASCADE,
            onDelete = ForeignKey.Companion.SET_NULL
        )]
)
data class UserAuth(
    val placeholder: String?, //yet to implement
    @PrimaryKey val id: Int
)
