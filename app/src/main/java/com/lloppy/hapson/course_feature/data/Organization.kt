package com.lloppy.hapson.course_feature.data

data class Organization(
    val id: String,
    val name: String,
    val courses: List<Course> = mutableListOf()
)