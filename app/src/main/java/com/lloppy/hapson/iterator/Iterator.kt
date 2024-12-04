package com.lloppy.hapson.iterator

import android.util.Log
import com.lloppy.hapson.course_feature.data.Course

// Паттерн Iterator
class ClassIteratorImpl(private val capacity: Int) : Iterable<Course> {
    private val classes = mutableListOf<Course>()

    fun getLength(): Int = classes.size
    fun isNotEmpty(): Boolean = classes.size > 0

    fun toList(): List<Course> {
        return classes.toList()
    }

    fun addClass(course: Course) {
        if (classes.size < capacity) {
            classes.add(course)
        } else {
            Log.e("iterator", "Limit! Please buy and upgrade your current plan!")
            Log.e("iterator", "Превышен лимит классов для организации!")
        }
    }

    override fun iterator(): Iterator<Course> {
        return object : Iterator<Course> {
            private var index = 0

            override fun hasNext(): Boolean {
                return index < classes.size
            }

            override fun next(): Course {
                if (!hasNext()) throw NoSuchElementException()
                return classes[index++]
            }
        }
    }
}
