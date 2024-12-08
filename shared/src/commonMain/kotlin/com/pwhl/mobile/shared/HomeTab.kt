package com.pwhl.mobile.shared

import com.pwhl.mobile.shared.feed.FeedScreen
import com.pwhl.mobile.shared.news.NewsScreen
import com.pwhl.mobile.shared.profile.ProfileScreen
import com.pwhl.mobile.shared.standings.StandingsScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class HomeTab<T>(
    val route: T,
) {
    @Serializable
    data object Feed : HomeTab<FeedScreen>(FeedScreen)

    @Serializable
    data object News : HomeTab<NewsScreen>(NewsScreen)

    @Serializable
    data object Standings : HomeTab<StandingsScreen>(StandingsScreen)

    @Serializable
    data object Profile : HomeTab<ProfileScreen>(ProfileScreen)
}
