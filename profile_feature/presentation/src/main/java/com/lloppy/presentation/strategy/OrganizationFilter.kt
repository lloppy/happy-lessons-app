package com.lloppy.presentation.strategy

import com.lloppy.presentation.data.Course

// Паттерн State
class OrganizationFilter(private var organizationId: String?) : Filterable {
    override fun applyFilter(courses: List<Course>): List<Course> {
        return if (!organizationId.isNullOrEmpty()) {
            courses.filter { it.organizationId == organizationId }
        } else {
            courses
        }
    }
}