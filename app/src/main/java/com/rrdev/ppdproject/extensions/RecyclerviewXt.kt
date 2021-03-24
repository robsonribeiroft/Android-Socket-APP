package com.rrdev.ppdproject.extensions

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.scrollToLastPosition(){
    adapter?.let {
        scrollToPosition(it.itemCount - 1)
    }
}