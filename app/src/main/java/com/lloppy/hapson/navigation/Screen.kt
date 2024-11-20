package com.lloppy.hapson.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector? = null) {
    object Groups : Screen(route = "groups_screen", icon = Icons.Filled.Person)
    object Chats : Screen(route = "chats_screen", icon = Icons.Filled.Home)
    object Classes : Screen(route = "classes_screen", icon = Icons.Filled.Home)

}