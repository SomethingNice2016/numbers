package com.somenthingnice.testtask.core.common.time

class TimeUtilsImpl : TimeUtils {

    override fun getCurrentTime() = System.currentTimeMillis()
}