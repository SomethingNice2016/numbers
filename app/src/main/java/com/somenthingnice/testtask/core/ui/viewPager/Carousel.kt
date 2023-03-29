package com.somenthingnice.testtask.core.ui.viewPager

import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

private const val SHRINK_DISTANCE = .75f
private const val SHRINK_AMOUNT = .55f

fun ViewPager2.setupCarousel(pageMargin: Int, leftOffset: Int) {
    clipToPadding = false
    clipChildren = false
    offscreenPageLimit = 3

    setPageTransformer { page, position ->
        val offset = position * (2 * leftOffset + pageMargin)

        if (orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
            page.translationX =
                if (ViewCompat.getLayoutDirection(this) == ViewCompat.LAYOUT_DIRECTION_RTL)
                    offset
                else
                    -offset
        } else
            page.translationY = offset

        page.let {
            val childCenter = it.left + (it.right - it.left) / 2f
            val parentWidthHalf = width / 2f
            val maxDistance = SHRINK_DISTANCE * parentWidthHalf
            val distance = maxDistance.coerceAtMost(abs(parentWidthHalf - childCenter))
            val position = 1f - SHRINK_AMOUNT * distance / maxDistance
            it.scaleX = position
            it.scaleY = position
        }
    }
}