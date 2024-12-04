package com.lloppy.hapson.course_feature.data

import com.lloppy.presentation.data.Course

data class User(
    val id: String,
    val name: String,
    val role: Role,
    val courses: List<Course> = mutableListOf()
)
