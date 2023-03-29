package com.somenthingnice.testtask.datasource.remote.numbers

import com.somenthingnice.testtask.entity.number.NumberInfo
import com.somenthingnice.testtask.core.data.flow.FlowTransaction

interface NumbersRemoteSource {

    fun getInfoByNumber(number: Long): FlowTransaction<NumberInfo>

}