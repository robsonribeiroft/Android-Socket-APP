package com.rrdev.ppdproject

import android.app.Application
import com.rrdev.ppdproject.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(appModule))
        }.androidContext(applicationContext)
    }
}