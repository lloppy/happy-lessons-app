package com.lloppy.hapson.course_feature.data

import com.lloppy.presentation.data.Course

data class Organization(
    val id: String,
    val name: String,
    val courses: List<Course> = mutableListOf()
)