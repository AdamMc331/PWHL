package com.adammcneilly.pwhl.mobile.shared.standings

import com.adammcneilly.pwhl.mobile.shared.displaymodels.StandingsRowDisplayModel

/**
 * Defines the UI state for the standings screen.
 */
data class StandingsState(
    val isLoading: Boolean,
    val standings: List<StandingsRowDisplayModel>,
) {
    // Remove after Detekt is updated: https://github.com/detekt/detekt/pull/7635/
    @Suppress("UndocumentedPublicClass")
    companion object {
        /**
         * Default state of the standings screen when it is first created.
         */
        val Default = StandingsState(
            isLoading = false,
            standings = emptyList(),
        )
    }
}
