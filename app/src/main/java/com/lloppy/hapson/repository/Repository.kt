package com.lloppy.hapson.repository

object Repository {
    private val organizations = listOf(
        Organization(
            id = "org1",
            name = "Школа №1",
            classes = listOf(
                Class(
                    id = "class1",
                    name = "Математика",
                    teachers = listOf(
                        Teacher(id = "teacher1", name = "Иванов Иван Иванович"),
                        Teacher(id = "teacher2", name = "Петрова Анна Сергеевна")
                    ),
                    students = listOf(
                        Student(id = "student1", name = "Смирнов Алексей Николаевич"),
                        Student(id = "student2", name = "Попова Ольга Викторовна")
                    ),
                    schedule = Schedule(
                        lessons = listOf(
                            Lesson("Математика", "Понедельник", "09:00 - 10:30"),
                            Lesson("Математика", "Среда", "11:00 - 12:30")
                        )
                    )
                ),
                Class(
                    id = "class2",
                    name = "Физика",
                    teachers = listOf(
                        Teacher(id = "teacher3", name = "Сидоров Алексей Викторович")
                    ),
                    students = listOf(
                        Student(id = "student3", name = "Кузнецов Сергей Павлович")
                    ),
                    schedule = Schedule(
                        lessons = listOf(
                            Lesson("Физика", "Вторник", "10:30 - 12:00"),
                            Lesson("Физика", "Четверг", "09:00 - 10:30")
                        )
                    )
                ),
                Class(
                    id = "class3",
                    name = "Литература",
                    teachers = listOf(
                        Teacher(id = "teacher4", name = "Федорова Елена Владимировна")
                    ),
                    students = listOf(
                        Student(id = "student4", name = "Лебедева Анна Игоревна")
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
            classes = listOf(
                Class(
                    id = "class4",
                    name = "Химия",
                    teachers = listOf(
                        Teacher(id = "teacher5", name = "Кузнецова Мария Петровна")
                    ),
                    students = listOf(
                        Student(id = "student5", name = "Григорьев Максим Андреевич"),
                        Student(id = "student6", name = "Семенова Наталья Викторовна")
                    ),
                    schedule = Schedule(
                        lessons = listOf(
                            Lesson("Химия", "Понедельник", "09:00 - 10:30"),
                            Lesson("Химия", "Среда", "10:30 - 12:00")
                        )
                    )
                ),
                Class(
                    id = "class5",
                    name = "Биология",
                    teachers = listOf(
                        Teacher(id = "teacher6", name = "Семенов Николай Андреевич")
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
            classes = listOf(
                Class(
                    id = "class6",
                    name = "История",
                    teachers = listOf(
                        Teacher(id = "teacher7", name = "Морозова Светлана Александровна")
                    ),
                    students = listOf(
                        Student(id = "student7", name = "Тихонов Игорь Валерьевич"),
                        Student(id = "student8", name = "Захарова Дарья Сергеевна")
                    ),
                    schedule = Schedule(
                        lessons = listOf(
                            Lesson("История", "Вторник", "09:00 - 10:30"),
                            Lesson("История", "Четверг", "11:00 - 12:30")
                        )
                    )
                ),
                Class(
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

    fun getClassesInOrganization(orgId: String): List<Class>? {
        return organizations.find { it.id == orgId }?.classes
    }
}
