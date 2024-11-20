package com.lloppy.hapson.screen.classes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClassesScreenViewModel @Inject constructor(
) : ViewModel() {
    private val _state = mutableStateOf(ClassesScreenState("org1"))
    val state: ClassesScreenState = _state.value

    fun getClasses(){
        _state.value.classes
    }


    fun onAction(action: ClassesAction) {
        when (action) {
            is ClassesAction.OnClassSelected -> {
                handleClassSelection(action.classId)
            }
        }
    }

    private fun handleClassSelection(classId: String) {
        println("Класс с ID $classId выбран.")
    }
}