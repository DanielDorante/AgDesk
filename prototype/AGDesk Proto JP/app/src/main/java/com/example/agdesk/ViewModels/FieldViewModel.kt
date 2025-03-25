package com.example.agdesk.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agdesk.models.FieldsModel
import com.example.agdesk.repository.FieldRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class FieldViewModel @Inject constructor(private val repository: FieldRepository): ViewModel() {


    private val _fields = MutableStateFlow<List<FieldsModel>>(emptyList())
    //State held here for collectors
    val fields: StateFlow<List<FieldsModel>> = _fields.asStateFlow()

    init {
        loadFields()
    }

    fun insertFields(vararg fields: FieldsModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) { //Executing jobs on the InputOutput Thread, good for database interaction
            repository.insertFields(*fields)
            loadFields()
        }
    }
    // Function to get a user by ID

    fun loadFields() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val fieldList = repository.getAllFields()
            _fields.value = fieldList // Update the StateFlow
        }

    }

}

