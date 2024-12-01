package com.pwhl.mobile.shared.feed

import com.pwhl.mobile.shared.displaymodels.GameDisplayModel

data class FeedState(
    val isLoading: Boolean,
    val recentGames: List<GameDisplayModel>,
)
