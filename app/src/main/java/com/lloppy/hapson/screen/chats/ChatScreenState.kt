package com.lloppy.hapson.screen.chats

import com.lloppy.hapson.repository.Class
import com.lloppy.hapson.repository.Organization
import com.lloppy.hapson.repository.Repository

data class ChatScreenState(
    val organization: Organization = Repository.getOrganizationById("org1")!!,
    val classes: List<Class>? = Repository.getClassesInOrganization(organization.id)
)