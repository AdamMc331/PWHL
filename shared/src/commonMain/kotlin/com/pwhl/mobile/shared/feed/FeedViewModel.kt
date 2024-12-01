package com.pwhl.mobile.shared.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pwhl.mobile.shared.displaymodels.GameDisplayModel
import com.pwhl.mobile.shared.domain.usecases.FetchRecentGamesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FeedViewModel(
    private val recentGamesUseCase: FetchRecentGamesUseCase,
) : ViewModel() {
    private val mutableState = MutableStateFlow(
        FeedState(
            isLoading = false,
            recentGames = emptyList(),
        ),
    )
    val state = mutableState.asStateFlow()

    init {
        fetchRecentGames()
    }

    private fun fetchRecentGames() {
        viewModelScope.launch {
            mutableState.update { currentState ->
                currentState.copy(
                    isLoading = true,
                )
            }

            val result = recentGamesUseCase.invoke()

            val gameList = result
                .getOrNull()
                .orEmpty()
                .map(::GameDisplayModel)

            mutableState.update { currentState ->
                currentState.copy(
                    isLoading = false,
                    recentGames = gameList,
                )
            }
        }
    }
}
