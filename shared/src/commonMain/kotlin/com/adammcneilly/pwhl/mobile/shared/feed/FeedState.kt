package com.adammcneilly.pwhl.mobile.shared.feed

import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameSummaryDisplayModel

data class FeedState(
    val loadingRecentGames: Boolean,
    val recentGames: Map<String, List<GameSummaryDisplayModel>>,
    val loadingUpcomingGames: Boolean,
    val upcomingGames: Map<String, List<GameSummaryDisplayModel>>,
) {
    companion object {
        val Default = FeedState(
            loadingRecentGames = false,
            recentGames = emptyMap(),
            loadingUpcomingGames = false,
            upcomingGames = emptyMap(),
        )
    }
}
