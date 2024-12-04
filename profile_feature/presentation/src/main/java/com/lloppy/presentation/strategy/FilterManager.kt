package com.lloppy.presentation.strategy

import com.lloppy.presentation.data.Course

// Паттерн Strategy
class FilterManager {
    fun applyFilters(filters: List<Filterable>, originalList: List<Course>): List<Course> {
        var filteredList = originalList
        for (filter in filters) {
            filteredList = filter.applyFilter(filteredList)
        }
        return filteredList
    }
}