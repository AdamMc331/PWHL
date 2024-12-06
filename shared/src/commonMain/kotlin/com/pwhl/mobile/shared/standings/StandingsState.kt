package com.pwhl.mobile.shared.standings

import com.pwhl.mobile.shared.displaymodels.StandingsRowDisplayModel

data class StandingsState(
    val isLoading: Boolean,
    val standings: List<StandingsRowDisplayModel>,
) {
    companion object {
        val Default = StandingsState(
            isLoading = false,
            standings = emptyList(),
        )
    }
}
