package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
data class Networkjob(
    val id: String,
    val name: String,
    val taskjob: String,
    val completejob: Boolean,
)

@Entity(tableName = "joblist")
data class JobEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    @ColumnInfo(name = "task")
    val taskjob: String,
    @ColumnInfo(name = "Complete")
    val completejob: Boolean,
)

/**
 * Converts the network model to the local model for persisting
 * by the local data source
 */
fun Networkjob.asEntity() = JobEntity(
    id = id,
    name = name,
    taskjob = taskjob,
    completejob = completejob
)

/**
 * Converts the local model to the external model for use
 * by layers external to the data layer
 */
fun JobEntity.asExternalModel() = Networkjob(
    id = id,
    name = name,
    taskjob = taskjob,
    completejob = completejob
)

