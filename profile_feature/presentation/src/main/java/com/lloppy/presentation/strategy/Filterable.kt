package com.lloppy.presentation.strategy

import com.lloppy.presentation.data.Course

// Паттерн Strategy
interface Filterable {
    fun applyFilter(courses: List<Course>): List<Course>
}