package com.adammcneilly.pwhl.mobile.shared.standings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.pwhl.mobile.shared.domain.usecases.FetchStandingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * State container for the standings screen.
 */
class StandingsViewModel(
    private val fetchStandingsUseCase: FetchStandingsUseCase,
) : ViewModel() {
    private val mutableState = MutableStateFlow(StandingsState.Default)
    val state = mutableState.asStateFlow()

    init {
        fetchStandings()
    }

    private fun fetchStandings() {
        mutableState.update { currentState ->
            currentState.copy(
                isLoading = true,
            )
        }

        viewModelScope.launch {
            val standings = fetchStandingsUseCase
                .invoke()
                .getOrNull()
                .orEmpty()

            mutableState.update { currentState ->
                currentState.copy(
                    isLoading = false,
                    standings = standings,
                )
            }
        }
    }
}
