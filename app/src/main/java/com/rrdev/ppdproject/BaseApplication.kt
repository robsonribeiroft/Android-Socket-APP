package com.rrdev.ppdproject

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.rrdev.ppdproject.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        startKoin {
            modules(listOf(appModule))
        }.androidContext(applicationContext)
    }

}