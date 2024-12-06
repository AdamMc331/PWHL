package com.pwhl.mobile.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pwhl.mobile.shared.feed.FeedScreen
import com.pwhl.mobile.shared.news.NewsScreen
import com.pwhl.mobile.shared.profile.ProfileScreen
import com.pwhl.mobile.shared.standings.StandingsScreen

enum class Screen(
    val route: String,
    val title: String,
    val render: @Composable (Modifier) -> Unit,
) {
    Feed(
        route = "feed",
        title = "Feed",
        render = { modifier ->
            FeedScreen(modifier)
        },
    ),
    News(
        route = "news",
        title = "News",
        render = { modifier ->
            NewsScreen(modifier)
        },
    ),
    Standings(
        route = "standings",
        title = "Standings",
        render = { modifier ->
            StandingsScreen(modifier)
        },
    ),
    Profile(
        route = "profile",
        title = "Profile",
        render = { modifier ->
            ProfileScreen(modifier)
        },
    ),
}
