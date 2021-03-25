package com.rrdev.ppdproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.rrdev.ppdproject.client.ClientSocket
import com.rrdev.ppdproject.mapper.Mapper
import com.rrdev.ppdproject.model.ChatMessage
import kotlinx.coroutines.flow.MutableStateFlow

class SocketViewModel(
    app: Application,
    private val client: ClientSocket
): AndroidViewModel(app) {

    var userName: String = ""
    val chatState = MutableStateFlow(ChatMessage("System", "Start Chat"))

    fun connectSocket(){
        client.initSocket()
        client.addListenerAndConnect()
        client.eventCallback = { event, data ->
            Log.d(TAG, "$event \n $data")
        }
    }

    fun disconnectSocket(){
        client.removeAllListeners()
    }

    fun sendMessageToChat(message: String) {
        val message = ChatMessage("You", message)
        chatState.value = message
        client.emitOn("chat", Mapper.fromChatToJson(message))
    }

    companion object{
        const val TAG = "SVM"
    }

}
