package com.example.agdesk.models.networkModels
import com.example.agdesk.DataLayer.entities.Asset.Expense
import com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel
import com.example.agdesk.models.networkModels.dataModels.DamageNetworkModel
import com.example.agdesk.models.networkModels.dataModels.ExpenseNetworkModel
import com.example.agdesk.models.networkModels.dataModels.OperationNetworkModel
import com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel
import kotlinx.serialization.Serializable

@Serializable
data class SyncWrite(
    val assets: List<AssetNetworkModel>,
    val tasks: List<TaskNetworkModel>,
    //val operations: List<OperationNetworkModel>,
    //val damages: List<DamageNetworkModel>,
    //val expenses: List<ExpenseNetworkModel>,

)
