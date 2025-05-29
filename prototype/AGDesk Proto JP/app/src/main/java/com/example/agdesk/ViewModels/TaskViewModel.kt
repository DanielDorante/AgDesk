package com.example.agdesk.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agdesk.DomainLayer.mapper.toEntity
import com.example.agdesk.models.UIModels.TaskModel
import com.example.agdesk.DomainLayer.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class TaskViewModel @Inject constructor(private val taskRepository: TaskRepository): ViewModel() {

    private val _tasks = MutableStateFlow<List<TaskModel>>(emptyList())
    //state held here ready for collectors
    val tasks: StateFlow<List<TaskModel>> = _tasks.asStateFlow()


    init {
        loadTasks()
    }

    //Saves a task to the database and refreshes the state post creation
    fun insertTasks(vararg taskModel: TaskModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) { //Executing jobs on the InputOutput Thread, good for database interaction
            taskRepository.insertTask(*taskModel)
            loadTasks()
        }
    }
    //updates state with a list of all the tasks
    fun loadTasks() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val taskList = taskRepository.getAllTasks()
            _tasks.value = taskList // Update the StateFlow
        }

    }

    //User system isn't fully implemented but it gets tasks based on the user in UserAuth
    fun loadUserTasks() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val taskList = taskRepository.getThisUsersTasks()
            _tasks.value = taskList // Update the StateFlow
        }

    }
    //Gets users by time frame, expects string of either 'Month' or 'Week'. Other strings will return all
    fun loadTasksByTimeFrame(timeFrame: String) = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val taskList = taskRepository.getTasksByTimeFrame(timeFrame)
            _tasks.value = taskList // Update the StateFlow
        }

    }

    //Updates a task via passing a complete TaskModel
    //It will check if the uid matches one in the database
    //Then updates every field in the task according to the TaskModel passed
    //Note: If you leave something null it will probably overwrite.
    fun updateTask(taskModel: TaskModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            taskRepository.updateTask(taskModel)
            loadTasks()
        }
    }

    // Delete a task
    fun deleteTask(taskModel: TaskModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            // First convert the TaskModel to an entity using the extension function
            val task = taskModel.toEntity(null)
            taskRepository.deleteTask(task)
            loadTasks() // Refresh the task list after deletion
        }
    }

}