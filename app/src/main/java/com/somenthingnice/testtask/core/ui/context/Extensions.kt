package com.somenthingnice.testtask.core.ui.context

import android.content.*
import android.graphics.Point

fun ContextWrapper.registerReceiver(receiver: BroadcastReceiver, vararg actions: String) {
    val filter = IntentFilter().apply {
        actions.forEach {
            addAction(it)
        }
    }
    registerReceiver(receiver, filter)
}


//fun Context.isLandscape(): Boolean = resources.getBoolean(R.bool.is_landscape)
//
//fun Context.isPortrait(): Boolean = !isLandscape()

val Context.screenSize: Point
    get() {
        val displayMetrics =
            resources.displayMetrics
        return Point().apply {
            x = displayMetrics.widthPixels
            y = displayMetrics.heightPixels
        }
    }