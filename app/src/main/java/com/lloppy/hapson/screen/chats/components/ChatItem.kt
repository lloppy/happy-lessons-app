package com.lloppy.hapson.screen.chats.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lloppy.hapson.course_feature.data.Chat

@Composable
fun ChatItem(chatItem: Chat, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = chatItem.id, style = MaterialTheme.typography.titleSmall)
        }

        LazyColumn {
            items(chatItem.messages){ message ->
                Text(text = message.text, style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}