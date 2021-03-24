package com.rrdev.ppdproject.extensions

import android.widget.EditText

const val DRAWABLE_END = 2

fun EditText.extractText(): String {
    val message = text.toString()
    setText("")
    return message
}

fun EditText.dimensDrawableEnd(): Int {
    return right - compoundDrawables[DRAWABLE_END].bounds.width()
}