package com.rrdev.ppdproject

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket
import com.rrdev.ppdproject.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SocketInstance: Application() {

    private var mSocket: Socket? = null

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//qfwDdGlztOgh9Eil
        try {
            val socketOptions = IO.Options()
            socketOptions.reconnection = true
            socketOptions.forceNew = true
            mSocket = IO.socket("https://192.168.15.6:3000", socketOptions)
        }catch (e: Exception){
            e.printStackTrace()
            throw RuntimeException(e)
        }

        startKoin {
            modules(listOf(appModule))
        }.androidContext(applicationContext)
    }

    fun getSocket(): Socket? = mSocket
}