package com.lloppy.hapson.course_feature.data

data class User(
    val id: String,
    val name: String,
    val role: Role,
    val courses: List<Course> = mutableListOf()
)
