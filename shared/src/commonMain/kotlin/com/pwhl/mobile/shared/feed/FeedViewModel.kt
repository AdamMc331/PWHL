package com.pwhl.mobile.shared.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pwhl.mobile.shared.displaymodels.GameDisplayModel
import com.pwhl.mobile.shared.domain.usecases.FetchRecentGamesUseCase
import com.pwhl.mobile.shared.domain.usecases.FetchUpcomingGamesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FeedViewModel(
    private val recentGamesUseCase: FetchRecentGamesUseCase,
    private val upcomingGamesUseCase: FetchUpcomingGamesUseCase,
) : ViewModel() {
    private val mutableState = MutableStateFlow(FeedState.Default)
    val state = mutableState.asStateFlow()

    init {
        println("ADAMLOG - INIT FEED VM")
        fetchRecentGames()
        fetchUpcomingGames()
    }

    private fun fetchRecentGames() {
        viewModelScope.launch {
            mutableState.update { currentState ->
                currentState.copy(
                    loadingRecentGames = true,
                )
            }

            val result = recentGamesUseCase.invoke()

            val gameList = result
                .getOrNull()
                .orEmpty()
                .map(::GameDisplayModel)

            mutableState.update { currentState ->
                currentState.copy(
                    loadingRecentGames = false,
                    recentGames = gameList,
                )
            }
        }
    }

    private fun fetchUpcomingGames() {
        viewModelScope.launch {
            mutableState.update { currentState ->
                currentState.copy(
                    loadingUpcomingGames = true,
                )
            }

            val result = upcomingGamesUseCase.invoke()

            val gameList = result
                .getOrNull()
                .orEmpty()
                .map(::GameDisplayModel)

            mutableState.update { currentState ->
                currentState.copy(
                    loadingUpcomingGames = false,
                    upcomingGames = gameList,
                )
            }
        }
    }
}
