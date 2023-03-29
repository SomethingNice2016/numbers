package com.somenthingnice.testtask.core.ui.view

import android.content.Context
import android.graphics.Point
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun List<View>.gone() {
    forEach { view ->
        view.gone()
    }
}

fun List<View>.visible() {
    forEach { view ->
        view.visible()
    }
}

fun List<View>.invisible() {
    forEach { view ->
        view.invisible()
    }
}

fun View.visibleInvisible(isVisible: Boolean) {
    if (isVisible) visible() else invisible()
}

fun View.visibleGone(isVisible: Boolean) {
    if (isVisible) visible() else gone()
}

fun List<View>.visibleInvisible(isVisible: Boolean) {
    forEach { view ->
        view.visibleInvisible(isVisible)
    }
}

fun List<View>.visibleGone(isVisible: Boolean) {
    forEach { view ->
        view.visibleGone(isVisible)
    }
}

val View.screenSize: Point
    get() {
        val displayMetrics =
            context.resources.displayMetrics
        return Point().apply {
            x = displayMetrics.widthPixels
            y = displayMetrics.heightPixels
        }
    }

fun View.convertDpToPixel(dp: Int): Float {
    return dp * context.resources.displayMetrics.density
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.showKeyboard() {
    postDelayed({
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, 0)
    }, 200L)
}

fun View.setKeyboardVisibility(isVisible: Boolean) {
    if (isVisible) showKeyboard() else hideKeyboard()
}

infix fun View?.setVisibility(visibility: Int) {
    this?.visibility = visibility
}

infix fun List<View>.setVisibility(visibility: Int) {
    forEach { view ->
        view setVisibility visibility
    }
}


