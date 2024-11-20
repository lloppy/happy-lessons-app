package com.lloppy.hapson.screen.chats

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ChatScreen(
    viewModel: ChatScreenViewModel = hiltViewModel()
) {
    Text(text = "ChatScreen")

}
