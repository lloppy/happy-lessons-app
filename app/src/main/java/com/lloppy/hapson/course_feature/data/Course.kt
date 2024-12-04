package com.lloppy.hapson.course_feature.data

data class Course(
    val id: String,
    var name: String,
    val teachers: List<User> = mutableListOf(),
    val students: List<User> = mutableListOf(),
    val schedule: Schedule
)