package com.somenthingnice.testtask.features.numberinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.somenthingnice.testtask.core.data.flow.unfold
import com.somenthingnice.testtask.domain.numbers.GetInfoByNumberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class NumberInfoViewModel @Inject constructor(
    private val getInfoByNumberUseCase: GetInfoByNumberUseCase
) : ViewModel() {


    private val _number = MutableStateFlow<Long?>(null)

    val state = _number.filterNotNull().flatMapLatest { number ->
        getInfoByNumberUseCase(number)
    }.unfold(
        loading = { NumberInfoViewState.Loading },
        success = { info -> NumberInfoViewState.fromInfo(info.info) },
        failure = { cause, _ -> NumberInfoViewState.Error(cause) }
    ).stateIn(
        scope = viewModelScope,
        initialValue = NumberInfoViewState.Initial,
        started = SharingStarted.WhileSubscribed()
    )


    fun searchNumberInfo(number: Long) {
        _number.value = number
    }
}