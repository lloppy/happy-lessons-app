package com.lloppy.hapson.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lloppy.hapson.screen.chats.ChatScreen
import com.lloppy.hapson.screen.groups.GroupsScreen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController,
    context: Context,
    lifecycleScope: LifecycleCoroutineScope,
    lifecycleOwner: LifecycleOwner,
    router: Router
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Groups.route
    ) {
        composable(Screen.Groups.route) {
            GroupsScreen()
        }

        composable(Screen.Chats.route) {
            ChatScreen()
        }

    }
}
