package com.lloppy.hapson.repository

import com.lloppy.hapson.course_feature.data.Chat
import com.lloppy.hapson.course_feature.data.Course
import com.lloppy.hapson.course_feature.data.Lesson
import com.lloppy.hapson.course_feature.data.Message
import com.lloppy.hapson.course_feature.data.Organization
import com.lloppy.hapson.course_feature.data.Role
import com.lloppy.hapson.course_feature.data.Schedule
import com.lloppy.hapson.course_feature.data.User

object Repository {
    private val chats = listOf(
        Chat(
            id = "chat1",
            messages = listOf(
                Message(
                    id = "mess1",
                    text = "message1 chat1"
                ),
                Message(
                    id = "mess2",
                    text = "message2 chat1"
                )
            )
        ),
        Chat(
            id = "chat2",
            messages = listOf(
                Message(
                    id = "mess3",
                    text = "message3 chat2"
                ),
                Message(
                    id = "mess4",
                    text = "message4 chat2"
                )
            )
        ),
        Chat(
            id = "chat3",
            messages = listOf(
                Message(
                    id = "mess5",
                    text = "message5 chat3"
                ),
                Message(
                    id = "mess6",
                    text = "message6 chat3"
                )
            )
        ),
    )
    private val organizations = listOf(
        Organization(
            id = "org1",
            name = "Школа №1",
            courses = listOf(
                Course(
                    id = "class1",
                    name = "Математика",
                    teachers = listOf(
                        User(id = "teacher1", name = "Иванов Иван Иванович", Role.TEACHER),
                        User(id = "teacher2", name = "Петрова Анна Сергеевна", Role.TEACHER)
                    ),
                    students = listOf(
                        User(id = "student1", name = "Смирнов Алексей Николаевич", Role.STUDENT),
                        User(id = "student2", name = "Попова Ольга Викторовна", Role.STUDENT)
                    ),
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
                    teachers = listOf(
                        User(id = "teacher3", name = "Сидоров Алексей Викторович", Role.TEACHER)
                    ),
                    students = listOf(
                        User(id = "student3", name = "Кузнецов Сергей Павлович", Role.STUDENT)
                    ),
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
                    teachers = listOf(
                        User(id = "teacher4", name = "Федорова Елена Владимировна", Role.TEACHER)
                    ),
                    students = listOf(
                        User(id = "student4", name = "Лебедева Анна Игоревна", Role.STUDENT)
                    ),
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
                    teachers = listOf(
                        User(id = "teacher5", name = "Кузнецова Мария Петровна", Role.TEACHER)
                    ),
                    students = listOf(
                        User(id = "student5", name = "Григорьев Максим Андреевич", Role.STUDENT),
                        User(id = "student6", name = "Семенова Наталья Викторовна", Role.STUDENT)
                    ),
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
                    teachers = listOf(
                        User(id = "teacher6", name = "Семенов Николай Андреевич", Role.TEACHER)
                    ),
                    students = listOf(),
                    schedule = Schedule(
                        lessons = listOf()
                    )
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
                    teachers = listOf(
                        User(
                            id = "teacher7",
                            name = "Морозова Светлана Александровна",
                            Role.TEACHER
                        )
                    ),
                    students = listOf(
                        User(id = "student7", name = "Тихонов Игорь Валерьевич", Role.STUDENT),
                        User(id = "student8", name = "Захарова Дарья Сергеевна", Role.STUDENT)
                    ),
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
                    teachers = listOf(),
                    students = listOf(),
                    schedule = Schedule(
                        lessons = listOf()
                    )
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
        val buffer = mutableListOf<Chat>()

        for (chatId in chatsIds) {
            val chat = chats.find { it.id == chatId }
            if (chat != null) buffer.add(chat)
        }
        return buffer
    }
}
