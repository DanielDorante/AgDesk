package com.example.agdesk.DataLayer.DAOs

import androidx.room.Dao
import androidx.room.Query
import com.example.agdesk.DataLayer.entities.User.*
import java.nio.channels.Selector

@Dao
interface UserDAO {
    @Query("SELECT id FROM UserAuth LIMIT 1")
    suspend fun getCurrentUser(): Int
}