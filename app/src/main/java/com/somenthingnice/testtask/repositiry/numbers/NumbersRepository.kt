package com.somenthingnice.testtask.repositiry.numbers

import com.somenthingnice.testtask.entity.number.NumberInfo
import com.somenthingnice.testtask.core.data.flow.FlowTransaction

interface NumbersRepository {

    fun getInfoByNumber(number: Long): FlowTransaction<NumberInfo>

}