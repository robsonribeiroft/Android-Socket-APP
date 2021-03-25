package com.rrdev.ppdproject.client

import android.util.Log
import com.rrdev.ppdproject.viewmodel.SocketViewModel
import io.socket.client.IO
import io.socket.client.Socket

object ClientSocket {

    private var mSocket: Socket? = null
    var eventCallback: ((String, Any) -> Unit)? = null

    fun initSocket(url: String = "http://192.168.15.6", port: Int = 3000){
        try {
            val options = IO.Options().apply {
                reconnection = true
                forceNew = true
            }
            mSocket = IO.socket("http://192.168.15.6:3000", options)
        }catch (e: Exception){
            e.printStackTrace()
            throw RuntimeException(e)
        }
    }

    fun addListenerAndConnect(){
        registerEventConnect()
        registerEventDisconnect()
        registerEventReconnect()
        mSocket?.connect()
        Log.d(SocketViewModel.TAG, "is connect ${mSocket?.connected()}")
    }

    private fun registerEventConnect(){
        mSocket?.on("connection"){
            Log.d(SocketViewModel.TAG, Socket.EVENT_CONNECT)
        }
    }

    private fun registerEventDisconnect(){
        mSocket?.on(Socket.EVENT_DISCONNECT){
            Log.d(SocketViewModel.TAG, Socket.EVENT_DISCONNECT)
        }
    }

    private fun registerEventReconnect(){
        mSocket?.on("reconnect"){
            Log.d(SocketViewModel.TAG, "reconnect")
        }
    }

    fun emitOn(event: String, data: String){
        mSocket?.emit(event, data)
    }

    fun removeAllListeners(){
        mSocket?.run {
            disconnect()
            off("connection")
            off("disconnect")
            off("reconnect")
        }
    }
}