package com.lloppy.presentation.repository

import com.lloppy.hapson.course_feature.data.Chat
import com.lloppy.hapson.course_feature.data.Lesson
import com.lloppy.hapson.course_feature.data.Message
import com.lloppy.hapson.course_feature.data.Organization
import com.lloppy.hapson.course_feature.data.Role
import com.lloppy.hapson.course_feature.data.Schedule
import com.lloppy.hapson.course_feature.data.User
import com.lloppy.presentation.data.Course

object CoursesRepository {
    private val chats = listOf(
        Chat(
            id = "chat1",
            messages = listOf(
                Message(id = "mess1", text = "message1 chat1"),
                Message(id = "mess2", text = "message2 chat1")
            )
        ),
        Chat(
            id = "chat2",
            messages = listOf(
                Message(id = "mess3", text = "message3 chat2"),
                Message(id = "mess4", text = "message4 chat2")
            )
        ),
        Chat(
            id = "chat3",
            messages = listOf(
                Message(id = "mess5", text = "message5 chat3"),
                Message(id = "mess6", text = "message6 chat3")
            )
        ),
    )

    private val users = listOf(
        User(id = "teacher1", name = "Иванов Иван Иванович", Role.TEACHER),
        User(id = "teacher2", name = "Петрова Анна Сергеевна", Role.TEACHER),
        User(id = "teacher3", name = "Сидоров Алексей Викторович", Role.TEACHER),
        User(id = "teacher4", name = "Федорова Елена Владимировна", Role.TEACHER),
        User(id = "teacher5", name = "Кузнецова Мария Петровна", Role.TEACHER),
        User(id = "teacher6", name = "Семенов Николай Андреевич", Role.TEACHER),
        User(id = "teacher7", name = "Морозова Светлана Александровна", Role.TEACHER)
    )

    private val organizations = listOf(
        Organization(
            id = "org1",
            name = "Школа №1",
            courses = listOf(
                Course(
                    id = "class1",
                    name = "Математика",
                    organizationId = "org1",
                    teachersId = listOf("teacher1", "teacher2"),
                    studentsId = listOf("student1", "student2"),
                    schedule = Schedule(
                        lessons = listOf(
                            Lesson("Математика", "Понедельник", "09:00 - 10:30"),
                            Lesson("Математика", "Среда", "11:00 - 12:30")
                        )
                    )
                ),
                Course(
                    id = "class2",
                    name = "Физика",
                    organizationId = "org1",
                    teachersId = listOf("teacher3"),
                    studentsId = listOf("student3"),
                    schedule = Schedule(
                        lessons = listOf(
                            Lesson("Физика", "Вторник", "10:30 - 12:00"),
                            Lesson("Физика", "Четверг", "09:00 - 10:30")
                        )
                    )
                ),
                Course(
                    id = "class3",
                    name = "Литература",
                    organizationId = "org1",
                    teachersId = listOf("teacher4"),
                    studentsId = listOf("student4"),
                    schedule = Schedule(
                        lessons = listOf(
                            Lesson("Литература", "Пятница", "11:00 - 12:30"),
                            Lesson("Литература", "Четверг", "11:00 - 12:30")
                        )
                    )
                )
            )
        ),
        Organization(
            id = "org2",
            name = "Гимназия №2",
            courses = listOf(
                Course(
                    id = "class4",
                    name = "Химия",
                    organizationId = "org2",
                    teachersId = listOf("teacher5"),
                    studentsId = listOf("student5", "student6"),
                    schedule = Schedule(
                        lessons = listOf(
                            Lesson("Химия", "Понедельник", "09:00 - 10:30"),
                            Lesson("Химия", "Среда", "10:30 - 12:00")
                        )
                    )
                ),
                Course(
                    id = "class5",
                    name = "Биология",
                    organizationId = "org2",
                    teachersId = listOf("teacher6"),
                    studentsId = emptyList(),
                    schedule = Schedule(lessons = emptyList())
                )
            )
        ),
        Organization(
            id = "org3",
            name = "Лицей №3",
            courses = listOf(
                Course(
                    id = "class6",
                    name = "История",
                    organizationId = "org3",
                    teachersId = listOf("teacher7"),
                    studentsId = listOf("student7", "student8"),
                    schedule = Schedule(
                        lessons = listOf(
                            Lesson("История", "Вторник", "09:00 - 10:30"),
                            Lesson("История", "Четверг", "11:00 - 12:30")
                        )
                    )
                ),
                Course(
                    id = "class7",
                    name = "География",
                    organizationId = "org3",
                    teachersId = emptyList(),
                    studentsId = emptyList(),
                    schedule = Schedule(lessons = emptyList())
                )
            )
        )
    )

    fun getOrganizations(): List<Organization> {
        return organizations
    }

    fun getOrganizationById(orgId: String): Organization? {
        return organizations.find { it.id == orgId }
    }

    fun getClassesInOrganization(orgId: String): List<Course>? {
        return organizations.find { it.id == orgId }?.courses
    }

    fun getChatsList(chatsIds: List<String>): List<Chat> {
        return chats.filter { it.id in chatsIds }
    }

    fun getUsersByIds(userIds: List<String>): List<User> {
        return users.filter { it.id in userIds }
    }
}