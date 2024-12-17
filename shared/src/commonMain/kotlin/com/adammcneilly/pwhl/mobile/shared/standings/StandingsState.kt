package com.adammcneilly.pwhl.mobile.shared.standings

import com.adammcneilly.pwhl.mobile.shared.displaymodels.StandingsRowDisplayModel

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
