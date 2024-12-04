package com.lloppy.hapson.screen.chats.components

sealed class ChatAction {
    data class OnChatSelected(val chatId: String) : ChatAction()
    data class OnAddNewChat(val chatId: String) : ChatAction()
}