package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.pwhl.mobile.shared.domain.usecases.FetchGameSummaryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameDetailViewModel(
    private val gameId: String,
    fetchGameSummaryUseCase: FetchGameSummaryUseCase,
) : ViewModel() {
    private val mutableState = MutableStateFlow(GameDetailState.Default)
    val state = mutableState.asStateFlow()

    init {
        viewModelScope.launch {
            mutableState.update { currentState ->
                currentState.copy(
                    isLoading = true,
                )
            }

            val game = fetchGameSummaryUseCase
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
