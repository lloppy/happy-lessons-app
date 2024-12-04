package com.lloppy.hapson.screen.classes.components

sealed class ClassesAction {
    data class OnClassSelected(val classId: String) : ClassesAction()
    data class OnAddNewClass(val classId: String) : ClassesAction()
}
