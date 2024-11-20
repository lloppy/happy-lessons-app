package com.lloppy.hapson.repository

data class Organization(
    val id: String,
    val name: String,
    val classes: List<Class> = mutableListOf()
)

data class Class(
    val id: String,
    val name: String,
    val teachers: List<Teacher> = mutableListOf(),
    val students: List<Student> = mutableListOf(),
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

data class Teacher(
    val id: String,
    val name: String,
    val classes: List<Class> = mutableListOf()
)

data class Student(
    val id: String,
    val name: String,
    val classes: List<Class> = mutableListOf()
)