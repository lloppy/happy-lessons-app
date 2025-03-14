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
import com.lloppy.presentation.CourseScreen
import com.lloppy.presentation.CoursesSearch
import com.lloppy.presentation.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    // Паттерн Template method
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
                        LoginScreen(
                            onClickLogin = {
                                navController.navigate(Route.CourseScreen)
                            },
                            onClickSignIn = {
                                navController.navigate(Route.CourseScreen)
                            },
                            onClickOrgLogin = {
                                navController.navigate(Route.CoursesSearch)
                            }
                        )
                    }

                    composable<Route.CourseScreen> {
                        GroupsScreen()
                    }

                    composable<Route.CoursesSearch> {
                        CoursesSearch()
                    }


                    composable<Route.ChatsScreen> {
                        ChatScreen()
                    }

                    composable<Route.CourseScreen> {
                        CourseScreen()
                    }

                    composable<Route.ClassesScreen> {
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
