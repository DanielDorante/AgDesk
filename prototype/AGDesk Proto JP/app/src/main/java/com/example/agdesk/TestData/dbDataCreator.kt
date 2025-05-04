package com.example.agdesk.TestData

import com.example.agdesk.DataLayer.entities.Task
import com.example.agdesk.models.*
import com.example.agdesk.repository.AssetRepository
import com.example.agdesk.repository.NetworkRepository
import com.example.agdesk.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.internal.InjectedFieldSignature
import javax.inject.Inject
import javax.inject.Singleton

class dbDataCreator @Inject constructor(private val networkRepository: NetworkRepository,private val assetRepository: AssetRepository,private val taskRepository: TaskRepository) {
    val j = 0

    suspend fun populateDB() {



        var i = 0;


        while (i < 5) {
            val asset = AssetModel(
                uid = null,
                assetPrefix = "LV",
                name = ("test" + i.toString()),
                manufac = ("test" + i.toString()),
                parts = ("test" + i.toString()),
                location = ("test" + i.toString()),
                dateMade = 1000,
                dateBuy = 1000,
                image = ("test" + i.toString()),
                farmId = 1,
                vin = 1234552345,
                serialNo = 14545,
                reg = 1545345345,
                syncId = null,
                checkoutStatus = false,
                checkoutBy = "test"
            )
            assetRepository.insertAsset(asset)

            val task = TaskModel(
                uid = null,
                name = ("test" + i.toString()),
                desc = ("test" + i.toString()),
                timestamp = 1,
                del = false,
                due = 1,
                exp = 1,
                status = 1,
                priority = 1,
                assigned = "name",
                farm = 1,
                syncid = null,
                assignedId = null,
            )
            taskRepository.insertTask(task)
            i = i + 1
        }
        networkRepository.syncToServer()
        networkRepository.syncFromServer("123154854")



    }

}

@Module
@InstallIn(SingletonComponent::class)
object TestModule {

    @Provides
    @Singleton
    fun provideDbDataCreator(
        networkRepository: NetworkRepository,
        assetRepository: AssetRepository,
        taskRepository: TaskRepository
    ): dbDataCreator {
        return dbDataCreator(networkRepository, assetRepository, taskRepository)
    }
}
