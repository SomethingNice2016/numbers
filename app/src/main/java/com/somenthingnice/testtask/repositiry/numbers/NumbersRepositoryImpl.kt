package com.somenthingnice.testtask.repositiry.numbers

import com.somenthingnice.testtask.core.data.mediator.TransactionMediator
import com.somenthingnice.testtask.datasource.local.sources.numbers.NumbersLocalSource
import com.somenthingnice.testtask.datasource.remote.numbers.NumbersRemoteSource
import javax.inject.Inject


class NumbersRepositoryImpl @Inject constructor(
    private val remote: NumbersRemoteSource,
    private val local: NumbersLocalSource
) : NumbersRepository {

    override fun getInfoByNumber(number: Long) =
        TransactionMediator(
            remote = { remote.getInfoByNumber(number) },
            local = { local.getInfoByNumber(number) },
            onCache = { info -> local.saveInfo(info) }
        ).execute()
}