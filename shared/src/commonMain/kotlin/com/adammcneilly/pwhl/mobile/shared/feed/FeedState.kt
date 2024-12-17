package com.adammcneilly.pwhl.mobile.shared.feed

import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameDisplayModel

data class FeedState(
    val loadingRecentGames: Boolean,
    val recentGames: Map<String, List<GameDisplayModel>>,
    val loadingUpcomingGames: Boolean,
    val upcomingGames: Map<String, List<GameDisplayModel>>,
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
