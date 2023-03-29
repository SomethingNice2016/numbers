package com.somenthingnice.testtask.datasource.remote.numbers

import com.somenthingnice.testtask.core.data.entity.Transaction
import com.somenthingnice.testtask.entity.number.NumberInfo
import com.somenthingnice.testtask.core.data.flow.flowWrap
import com.somenthingnice.testtask.core.data.flow.transform
import javax.inject.Inject

class NumbersRemoteSourceImpl @Inject constructor(
    private val numbersApi: NumbersApi
) : NumbersRemoteSource {


    override fun getInfoByNumber(number: Long) = Transaction.flowWrap {
        numbersApi.getInfoByNumber(number).string()
    }.transform { info ->
        NumberInfo(
            number = number,
            info = info
        )
    }

}