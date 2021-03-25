package com.rrdev.ppdproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.rrdev.ppdproject.model.ChatMessage
import kotlinx.coroutines.flow.MutableStateFlow

class SocketViewModel(
    app: Application
): AndroidViewModel(app) {

    var userName: String = ""
    val chatState = MutableStateFlow(ChatMessage("System", "Start Chat"))
    //private val mSocket: Socket? = (app as SocketInstance).getSocket()

/*
    fun init(){
        registerEventConnect()
        registerEventDisconnect()
        registerEventReconnect()
        mSocket?.connect()
        Log.d(TAG, "is connect ${mSocket?.connected()}")
    }

    private fun registerEventConnect(){
        mSocket?.on(Socket.EVENT_CONNECT){ args: Array<out Any>? ->
            Log.d(TAG, Socket.EVENT_CONNECT)
        }
    }

    private fun registerEventDisconnect(){
        mSocket?.on(Socket.EVENT_DISCONNECT){ args: Array<out Any>? ->
            Log.d(TAG, Socket.EVENT_DISCONNECT)
        }
    }

    private fun registerEventReconnect(){
        mSocket?.on(Socket.EVENT_RECONNECT){ args: Array<out Any>? ->
            Log.d(TAG, Socket.EVENT_RECONNECT)
        }
    }

    fun removeAllListeners(){
        mSocket?.run {
            disconnect()
            off(Socket.EVENT_CONNECT)
            off(Socket.EVENT_DISCONNECT)
            off(Socket.EVENT_RECONNECT)
        }
    }

    fun sendMessageToChat(message: String) {
        val message = ChatMessage("You", message)
        chatState.value = message
        mSocket?.emit(Socket.EVENT_MESSAGE, Mapper.fromChatToJson(message))
    }

    companion object{
        const val TAG = "SVM"
    }
*/

}
