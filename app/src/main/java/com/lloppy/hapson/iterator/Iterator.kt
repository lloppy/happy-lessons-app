package com.lloppy.hapson.iterator

import android.util.Log
import com.lloppy.hapson.repository.ClassModel

// Паттерн Iterator
class ClassIteratorImpl(private val capacity: Int) : Iterable<ClassModel> {
    private val classes = mutableListOf<ClassModel>()

    fun getLength(): Int = classes.size
    fun isNotEmpty(): Boolean = classes.size > 0

    fun toList(): List<ClassModel> {
        return classes.toList()
    }

    fun addClass(classModel: ClassModel) {
        if (classes.size < capacity) {
            classes.add(classModel)
        } else {
            Log.e("iterator", "Limit! Please buy and upgrade your current plan!")
            Log.e("iterator", "Превышен лимит классов для организации!")
        }
    }

    override fun iterator(): Iterator<ClassModel> {
        return object : Iterator<ClassModel> {
            private var index = 0

            override fun hasNext(): Boolean {
                return index < classes.size
            }

            override fun next(): ClassModel {
                if (!hasNext()) throw NoSuchElementException()
                return classes[index++]
            }
        }
    }
}
