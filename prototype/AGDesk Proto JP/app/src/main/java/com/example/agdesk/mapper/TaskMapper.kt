package com.example.agdesk.mapper

import com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel
import com.example.agdesk.DataLayer.entities.Task
import java.util.UUID

fun TaskNetworkModel.toEntity(existingUid: String? = null): Task {
    return Task(
        uid = existingUid ?: UUID.randomUUID().toString(),
        name = this.name,
        desc = this.desc,
        timestamp = this.timestamp,
        del = this.del,
        due = this.due,
        exp = this.exp,
        status = this.status,
        priority = this.priority,
        assigned = this.assignedId,
        farm = this.farm,
        syncid = this.syncid
    )
}