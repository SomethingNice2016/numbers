package com.somenthingnice.testtask.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.somenthingnice.testtask.core.data.common.onFailure
import com.somenthingnice.testtask.core.data.common.onSuccess
import com.somenthingnice.testtask.domain.hisotry.GetHistoryUseCase
import com.somenthingnice.testtask.domain.hisotry.SaveToHistoryUseCase
import com.somenthingnice.testtask.entity.hisoty.HistoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val saveToHistoryUseCase: SaveToHistoryUseCase,
    getHistoryUseCase: GetHistoryUseCase
) : ViewModel() {

    sealed class State {
        class Content(
            val history: List<HistoryItem>
        ) : State()

        object Empty : State()
        object Idle : State()
    }

    sealed interface Event {
        class OnSaveSuccess(val number: Long) : Event
        object OnSaveError : Event
    }

    private val _event = MutableSharedFlow<Event>()

    val event: Flow<Event>
        get() = _event

    val state = getHistoryUseCase().map { history ->
        if (history.isEmpty())
            State.Empty
        else
            State.Content(history)
    }.stateIn(
        initialValue = State.Idle,
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed()
    )

    fun saveToHistory(number: Long) {
        viewModelScope.launch {
            saveToHistoryUseCase(number).onSuccess {
                _event.emit(Event.OnSaveSuccess(number))
            }.onFailure { _, _ ->
                _event.emit(Event.OnSaveError)
            }
        }
    }

}