package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.pwhl.mobile.shared.domain.usecases.FetchGameDetailUseCase
import com.adammcneilly.pwhl.mobile.shared.domain.usecases.FetchPlayByPlayUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameDetailViewModel(
    private val gameId: String,
    fetchGameDetailUseCase: FetchGameDetailUseCase,
    fetchPlayByPlayUseCase: FetchPlayByPlayUseCase,
) : ViewModel() {
    private val mutableState = MutableStateFlow(GameDetailState.Default)
    val state = mutableState.asStateFlow()

    init {
        fetchGameDetail(fetchGameDetailUseCase)
        fetchPlayByPlayEvents(fetchPlayByPlayUseCase)
    }

    private fun fetchPlayByPlayEvents(
        fetchPlayByPlayUseCase: FetchPlayByPlayUseCase,
    ) {
        viewModelScope.launch {
            val playByPlayEvents = fetchPlayByPlayUseCase
                .invoke(gameId)
                .getOrNull()
                .orEmpty()

            mutableState.update { currentState ->
                currentState.copy(
                    playByPlayEvents = playByPlayEvents,
                )
            }
        }
    }

    private fun fetchGameDetail(
        fetchGameDetailUseCase: FetchGameDetailUseCase,
    ) {
        viewModelScope.launch {
            mutableState.update { currentState ->
                currentState.copy(
                    isLoading = true,
                )
            }

            val game = fetchGameDetailUseCase
                .invoke(gameId)
                .getOrNull()

            mutableState.update { currentState ->
                currentState.copy(
                    isLoading = false,
                    game = game,
                )
            }
        }
    }
}
