package com.somenthingnice.testtask.datasource.local.sources.numbers

import com.somenthingnice.testtask.core.data.flow.transform
import com.somenthingnice.testtask.core.data.flow.wrap
import com.somenthingnice.testtask.datasource.local.entity.numbers.toDomain
import com.somenthingnice.testtask.datasource.local.entity.numbers.toEntity
import com.somenthingnice.testtask.entity.number.NumberInfo
import javax.inject.Inject

class NumbersLocalSourceImpl @Inject constructor(
    private val numbersDao: NumberDao
) : NumbersLocalSource {

    override fun getInfoByNumber(number: Long) =
        numbersDao.getInfoByNumber(number)
            .wrap()
            .transform { entity ->
                entity.toDomain()
            }

    override suspend fun saveInfo(info: NumberInfo) {
        numbersDao.insertNumberInfo(info.toEntity())
    }
}