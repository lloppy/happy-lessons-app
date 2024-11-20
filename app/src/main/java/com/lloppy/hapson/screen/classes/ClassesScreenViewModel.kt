package com.lloppy.hapson.screen.classes

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lloppy.hapson.iterator.ClassIteratorImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClassesScreenViewModel @Inject constructor(
) : ViewModel() {
    private val _state = mutableStateOf(ClassesScreenState("org1"))
    val state: ClassesScreenState = _state.value

    fun onAction(action: ClassesAction) {
        when (action) {
            is ClassesAction.OnClassSelected -> {
                handleClassSelection(action.classId)
            }
            is ClassesAction.OnAddNewClass -> {
                handleOnAddNewClass(action.classId)
            }
        }
    }

    private fun handleOnAddNewClass(classId: String) {
        Log.e("iterator", "handleOnAddNewClass, $classId")
    }

    private fun handleClassSelection(classId: String) {
        Log.e("iterator", "Класс с ID $classId выбран.")
    }
}