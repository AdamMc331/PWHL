package com.pwhl.mobile.shared.standings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pwhl.mobile.shared.domain.usecases.FetchStandingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StandingsViewModel(
    private val fetchStandingsUseCase: FetchStandingsUseCase,
) : ViewModel() {
    private val mutableState = MutableStateFlow(StandingsState.Default)
    val state = mutableState.asStateFlow()

    init {
        fetchStandings()
    }

    private fun fetchStandings() {
        viewModelScope.launch {
            val standings = fetchStandingsUseCase
                .invoke()
                .getOrNull()
                .orEmpty()

            println("ADAMLOG - STANDINGS: $standings")

            mutableState.update { currentState ->
                currentState.copy(
                    standings = standings,
                )
            }
        }
    }
}
