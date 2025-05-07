package com.example.agdesk.DomainLayer.mapper


import com.example.agdesk.DataLayer.entities.Asset.Asset
import com.example.agdesk.DataLayer.entities.Task
import com.example.agdesk.models.UIModels.AssetModel
import com.example.agdesk.models.UIModels.TaskModel
import com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel
import java.util.UUID

// TaskModel to Task (Entity)
fun TaskModel.toEntity(syncID: Task?): Task {
    return Task(
        uid = this.uid?.toString() ?: UUID.randomUUID().toString(), // Convert UUID to String
        name = this.name,
        desc = this.desc,
        // Convert Date to Unix timestamp (Long, in milliseconds)
        timestamp = this.timestamp?.time,  // Convert Date to Long (milliseconds)
        del = this.del ?: false,
        due = this.due?.time,  // Convert Date to Long (milliseconds)
        exp = this.exp?.time,  // Convert Date to Long (milliseconds)
        status = this.status,
        priority = this.priority,
        assigned = this.assignedId,
        farm = this.farm,
        syncid = syncID?.syncid
    )
}

fun TaskNetworkModel.toEntity(): Task {
    return Task(
        uid = this.uid ?: UUID.randomUUID().toString(),  // Ensure UID is not null; generate if missing
        name = this.name,  // Direct mapping
        desc = this.desc,  // Direct mapping
        timestamp = this.timestamp,  // Direct mapping for timestamp (already in Long)
        del = this.del ?: false,  // If null, default to false
        due = this.due,  // Direct mapping for due date (already in Long)
        exp = this.exp,  // Direct mapping for expiration date (already in Long)
        status = this.status,  // Direct mapping for status
        priority = this.priority,  // Direct mapping for priority
        assigned = this.assignedId,  // Direct mapping for assigned user ID
        farm = this.farm,  // Direct mapping for farm ID
        syncid = this.syncId,  // Direct mapping for sync ID

    )
}





// Extension function to map AssetModel to Asset entity
fun AssetModel.toAssetEntity(syncID: Asset?): Asset {
    return Asset(
        uid = this.uid?.toString() ?: UUID.randomUUID().toString(),  // Convert UUID to String
        assetPrefix = this.assetPrefix,
        name = this.name,
        manufac = this.manufac,
        parts = this.parts,
        location = this.location,
        dateMade = this.dateMade?.time,  // Convert Date to Long timestamp (milliseconds)
        dateBuy = this.dateBuy?.time,    // Convert Date to Long timestamp (milliseconds)
        isDel = false,                   // Assuming false (not deleted) unless specified elsewhere
        image = this.image,
        farmId = this.farmId,
        syncId = syncID?.syncId                // This might be set manually later during insert or sync
    )
}
