package com.somenthingnice.testtask.core.ui.activity

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest


fun AppCompatActivity.setupTheme(isNightMode: Boolean) {
    val key = if (isNightMode) AppCompatDelegate.MODE_NIGHT_YES
    else AppCompatDelegate.MODE_NIGHT_NO
    AppCompatDelegate.setDefaultNightMode(key)
}

fun AppCompatActivity.setupOrientation(isPortrait: Boolean) {
    requestedOrientation = if (isPortrait) ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    else ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

}

inline fun <reified E, reified F : Flow<E>> AppCompatActivity.collect(
    flow: F,
    crossinline collector: suspend (E) -> Unit
) {
    lifecycleScope.launchWhenCreated {
        flow.collectLatest {
            collector.invoke(it)
        }
    }
}
