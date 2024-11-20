package com.lloppy.hapson.screen.classes

import com.lloppy.hapson.repository.Class
import com.lloppy.hapson.repository.Organization
import com.lloppy.hapson.repository.Repository

data class ClassesScreenState(
    val organizationId: String,
    val organization: Organization = Repository.getOrganizationById(organizationId)!!,
    val classes: List<Class>? = Repository.getClassesInOrganization(organizationId)
)