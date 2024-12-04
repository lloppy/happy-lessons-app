package com.lloppy.presentation.data

import com.lloppy.hapson.course_feature.data.Schedule

data class Course(
    val id: String,
    var name: String,
    var organizationId: String,
    val teachersId: List<String> = mutableListOf(),
    val studentsId: List<String> = mutableListOf(),
    val schedule: Schedule
)