package com.dadehfa.toranj.common.utils

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers

val coroutineContextIO = Dispatchers.IO + CoroutineExceptionHandler { coroutineContext, throwable ->
    throwable.printWithTag(coroutineContext.toString())
}

private fun Throwable.printWithTag(
    tag: String = "LEGZO",
    label: String = "",
    etc: String = "",
) {
    Log.d(
        tag,
        buildString {
            if (label.isNotBlank()) {
                append(label)
            } else {
                append(tag)
            }
            append(" -> ")
            append(this@printWithTag.message)
            append("(")
            append(this@printWithTag.cause)
            append(")")
            if (etc.isNotBlank()) {
                append(" / ")
                append(etc)
            }
        },
    )
}