package com.lloppy.hapson.screen.chats

import com.lloppy.hapson.course_feature.data.Chat
import com.lloppy.hapson.repository.Repository

data class ChatScreenState(
    val chatsIds: List<String>,
    val chats: MutableList<Chat> = mutableListOf()
) {
    init {
        Repository.getChatsList(chatsIds).forEach { chatModel ->
            chats.add(chatModel)
        }
    }
}