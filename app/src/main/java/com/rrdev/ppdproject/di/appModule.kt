package com.rrdev.ppdproject.di

import com.rrdev.ppdproject.viewmodel.SocketViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SocketViewModel(get()) }
}