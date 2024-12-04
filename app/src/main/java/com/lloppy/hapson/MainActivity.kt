package com.lloppy.hapson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lloppy.hapson.screen.chats.ChatScreen
import com.lloppy.hapson.screen.classes.ClassesScreen
import com.lloppy.hapson.screen.classes.components.ClassDetailScreen
import com.lloppy.hapson.screen.groups.GroupsScreen
import com.lloppy.hapson.ui.theme.HapsonTheme
import com.lloppy.navigation.Route
import com.lloppy.presentation.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HapsonTheme {
                navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Route.LoginScreen
                ) {
                    composable<Route.LoginScreen> {
                        LoginScreen()
                    }

                    composable<Route.CourseScreen> {
                        GroupsScreen()
                    }

                    composable<Route.ChatsScreen> {
                        ChatScreen()
                    }

                    composable<Route.CourseScreen> {
                        ClassesScreen()
                    }
                    composable("class_detail/{classId}") { backStackEntry ->
                        val classId = backStackEntry.arguments?.getString("classId")
                        if (classId != null) {
                            ClassDetailScreen(classId)
                        }
                    }
                }
            }
        }
    }
}
