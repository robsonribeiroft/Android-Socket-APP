package com.rrdev.ppdproject.mapper

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.rrdev.ppdproject.model.ChatMessage

object Mapper {

    private val gson = Gson()

    fun argsToChat(args: Array<Any?>): ChatMessage{
        return gson.fromJson(args.first() as JsonObject, ChatMessage::class.java)
    }

    fun fromChatToJson(chatMessage: ChatMessage): String {
        return gson.toJson(chatMessage)
    }
}