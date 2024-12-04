package com.lloppy.hapson.course_feature.data

class CourseDataSource(

) {
    suspend fun getCourses(): List<Course>{
        return emptyList()
    }

    suspend fun saveCourse(course: Course){
        course
    }

}