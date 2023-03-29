package com.somenthingnice.testtask.features.numberinfo

sealed class NumberInfoViewState {

    object Initial : NumberInfoViewState()

    object Loading : NumberInfoViewState()

    object Empty : NumberInfoViewState()

    data class Content(
        val info: String
    ) : NumberInfoViewState()

    data class Error(
        val cause: Throwable?
    ) : NumberInfoViewState()

    companion object {
        fun fromInfo(info: String): NumberInfoViewState {
            return if (info.isEmpty())
                NumberInfoViewState.Empty
            else NumberInfoViewState.Content(info)
        }
    }
}

