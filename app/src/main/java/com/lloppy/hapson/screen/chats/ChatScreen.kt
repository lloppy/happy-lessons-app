package com.lloppy.hapson.screen.chats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChatScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
/*
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

 */
    }
}
