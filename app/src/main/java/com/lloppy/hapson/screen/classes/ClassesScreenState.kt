package com.lloppy.hapson.screen.classes

import com.lloppy.hapson.iterator.ClassIteratorImpl
import com.lloppy.hapson.repository.ClassModel
import com.lloppy.hapson.repository.Organization
import com.lloppy.hapson.repository.Repository

data class ClassesScreenState(
    val organizationId: String,
    val organization: Organization = Repository.getOrganizationById(organizationId)!!,
    val classModels: ClassIteratorImpl = ClassIteratorImpl(capacity = 5)
){
    init {
        Repository.getClassesInOrganization(organizationId)?.forEach { classModel ->
            classModels.addClass(classModel)
        }
    }
}