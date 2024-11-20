package com.lloppy.hapson.screen.chats

import com.lloppy.hapson.repository.ClassModel
import com.lloppy.hapson.repository.Organization
import com.lloppy.hapson.repository.Repository

data class ChatScreenState(
    val organization: Organization = Repository.getOrganizationById("org1")!!,
    val classModels: List<ClassModel>? = Repository.getClassesInOrganization(organization.id)
)