package com.lloppy.hapson.screen.chats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lloppy.hapson.screen.chats.components.ChatAction
import com.lloppy.hapson.screen.chats.components.ChatItem

@Composable
fun ChatScreen(
    onAction: (ChatAction) -> Unit,
    state: ChatScreenState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (state.chats.isNotEmpty()) {
            LazyColumn {
                items(state.chats.toList()) { chatItem ->
                    ChatItem(chatItem) {
                        onAction(ChatAction.OnChatSelected(chatItem.id))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        } else {
            Text(text = "Нет доступных чатов")
        }
    }
}

@Preview(name = "classes")
@Composable
private fun PreviewChatScreen() {
    ChatScreen(
        {}, ChatScreenState(listOf("chat1", "chat2"))
    )
}