package com.rrdev.ppdproject.model

data class ChatMessage(val user: String = "", val message: String){

    fun formatToChat(): String {
        return "$user: \n$message"
    }
}
