package com.lloppy.hapson.repository

data class Organization(
    val id: String,
    val name: String,
    val classModels: List<ClassModel> = mutableListOf()
)

data class ClassModel(
    val id: String,
    var name: String,
    val teachers: List<User> = mutableListOf(),
    val students: List<User> = mutableListOf(),
    val schedule: Schedule
)

data class Lesson(
    val subject: String,
    val dayOfWeek: String,
    val time: String
)

data class Schedule(
    val lessons: List<Lesson>
)

data class User(
    val id: String,
    val name: String,
    val role: Role,
    val classModels: List<ClassModel> = mutableListOf()
)

enum class Role {
    STUDENT,
    TEACHER
}