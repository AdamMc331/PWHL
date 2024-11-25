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
            recentGames = emptyList(),
        ),
    )
    val state = mutableState.asStateFlow()

    fun fetchData() {
        viewModelScope.launch {
            val x = recentGamesUseCase.invoke()
            println("ADAMLOG - $x")
            val gameList = x.getOrNull()?.map { game ->
                GameDisplayModel(game)
            }
            mutableState.update { currentState ->
                currentState.copy(
                    recentGames = gameList.orEmpty(),
                )
            }
        }
    }
}
