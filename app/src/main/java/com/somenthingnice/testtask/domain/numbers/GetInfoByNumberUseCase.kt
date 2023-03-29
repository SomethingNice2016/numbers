package com.somenthingnice.testtask.domain.numbers

import com.somenthingnice.testtask.di.IODispatcher
import com.somenthingnice.testtask.repositiry.numbers.NumbersRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetInfoByNumberUseCase @Inject constructor(
    private val numbersRepository: NumbersRepository,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher
) {

    operator fun invoke(number: Long) =
        numbersRepository.getInfoByNumber(number)
            .flowOn(dispatcher)

}