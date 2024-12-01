package com.pwhl.mobile.shared.feed

import com.pwhl.mobile.shared.displaymodels.GameDisplayModel

data class FeedState(
    val loadingRecentGames: Boolean,
    val recentGames: List<GameDisplayModel>,
    val loadingUpcomingGames: Boolean,
    val upcomingGames: List<GameDisplayModel>,
) {
    companion object {
        val Default = FeedState(
            loadingRecentGames = false,
            recentGames = emptyList(),
            loadingUpcomingGames = false,
            upcomingGames = emptyList(),
        )
    }
}
