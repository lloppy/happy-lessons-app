package com.lloppy.presentation.strategy

import com.lloppy.presentation.data.Course

// Паттерн Strategy
class NameFilter(private var nameQuery: String?) : Filterable {
    override fun applyFilter(courses: List<Course>): List<Course> {
        return if (!nameQuery.isNullOrEmpty()) {
            courses.filter { it.name.contains(nameQuery!!, ignoreCase = true) }
        } else {
            courses
        }
    }
}