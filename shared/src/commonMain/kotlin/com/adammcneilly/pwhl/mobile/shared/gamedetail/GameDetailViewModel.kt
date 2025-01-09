package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.pwhl.mobile.shared.domain.usecases.FetchGameDetailUseCase
import com.adammcneilly.pwhl.mobile.shared.domain.usecases.FetchPlayByPlayUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * This is the state container for a game detail screen, managing data requests
 * for a specific [gameId].
 */
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

    fun handleEvent(
        event: GameDetailUiEvent,
    ) {
        when (event) {
            is GameDetailUiEvent.MvpClicked -> selectMvp(event)
            is GameDetailUiEvent.PlayByPlayClicked -> selectPlayByPlayEvent(event)
        }
    }

    private fun selectPlayByPlayEvent(
        event: GameDetailUiEvent.PlayByPlayClicked,
    ) {
        mutableState.update { currentState ->
            val newPlayByPlayEvent = if (currentState.selectedPlayByPlayEvent == event.item) {
                null
            } else {
                event.item
            }

            currentState.copy(
                selectedPlayByPlayEvent = newPlayByPlayEvent,
            )
        }
    }

    private fun selectMvp(
        event: GameDetailUiEvent.MvpClicked,
    ) {
        mutableState.update { currentState ->
            val newPlayerId = if (currentState.selectedMvpId == event.playerId) {
                null
            } else {
                event.playerId
            }

            currentState.copy(
                selectedMvpId = newPlayerId,
            )
        }
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
