package com.lloppy.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object LoginScreen: Route

    @Serializable
    data object OrganizationScreen: Route

    @Serializable
    data object CourseScreen: Route

    @Serializable
    data object ChatsScreen: Route

    @Serializable
    data object ClassesScreen: Route

    @Serializable
    data object CoursesSearch: Route


}