package com.lloppy.hapson.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lloppy.hapson.screen.chats.ChatScreen
import com.lloppy.hapson.screen.chats.ChatScreenViewModel
import com.lloppy.hapson.screen.classes.components.ClassDetailScreen
import com.lloppy.hapson.screen.classes.ClassesScreen
import com.lloppy.hapson.screen.classes.ClassesScreenViewModel
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
            ChatsScreenRoot(
                navigateAction = { navigation ->
                    when (navigation) {
                        is ScreenNavigation.OnChatSelected -> {
                            navHostController.navigate("chat_detail/${navigation.chatId}")
                        }

                        else -> {}
                    }
                }
            )
        }

        composable(Screen.Classes.route) {
            ClassesScreenRoot(
                navigateAction = { navigation ->
                    when (navigation) {
                        is ScreenNavigation.ToClassDetail -> {
                            navHostController.navigate("class_detail/${navigation.classId}")
                        }

                        else -> {}
                    }
                }
            )
        }
        composable("class_detail/{classId}") { backStackEntry ->
            val classId = backStackEntry.arguments?.getString("classId")
            if (classId != null) {
                ClassDetailScreen(classId)
            }
        }
    }
}

@Composable
private fun ClassesScreenRoot(
    navigateAction: (ScreenNavigation) -> Unit,
    viewModel: ClassesScreenViewModel = hiltViewModel()
) {
    ClassesScreen(
        viewModel::onAction,
        viewModel.state
    )
}

@Composable
private fun ChatsScreenRoot(
    navigateAction: (ScreenNavigation) -> Unit,
    viewModel: ChatScreenViewModel = hiltViewModel()
) {
    ChatScreen(
        viewModel::onAction,
        viewModel.state
    )
}


sealed class ScreenNavigation {
    data class OnChatSelected(val chatId: String) : ScreenNavigation()
    data class ToClassDetail(val classId: String) : ScreenNavigation()
}