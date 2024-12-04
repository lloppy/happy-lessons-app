package com.lloppy.presentation.strategy

import com.lloppy.presentation.data.Course

// Паттерн State
interface Filterable {
    fun applyFilter(courses: List<Course>): List<Course>
}