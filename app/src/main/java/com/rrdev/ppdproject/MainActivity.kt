package com.rrdev.ppdproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rrdev.ppdproject.viewmodel.SocketViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val vm: SocketViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        vm.disconnectSocket()
        super.onDestroy()
    }

}