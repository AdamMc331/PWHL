package com.pwhl.mobile.shared.standings

import com.pwhl.mobile.shared.displaymodels.StandingsRowDisplayModel

data class StandingsState(
    val standings: List<StandingsRowDisplayModel>,
) {
    companion object {
        val Default = StandingsState(
            standings = emptyList(),
        )
    }
}
