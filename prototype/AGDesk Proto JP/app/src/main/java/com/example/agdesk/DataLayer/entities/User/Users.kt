package com.example.agdesk.DataLayer.entities.User

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users( // yet to implement
    val placeholder: String?,
    @PrimaryKey val id: Long

)
