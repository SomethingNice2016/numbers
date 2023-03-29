package com.somenthingnice.testtask.datasource.local.sources.numbers

import com.somenthingnice.testtask.core.data.flow.FlowTransaction
import com.somenthingnice.testtask.entity.number.NumberInfo

interface NumbersLocalSource {

    fun getInfoByNumber(number: Long): FlowTransaction<NumberInfo>

    suspend fun saveInfo(info: NumberInfo)

}