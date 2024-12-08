package com.pwhl.mobile.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.pwhl.mobile.shared.feed.FeedScreen
import com.pwhl.mobile.shared.gamedetail.GameDetailScreen
import com.pwhl.mobile.shared.news.NewsScreen
import com.pwhl.mobile.shared.profile.ProfileScreen
import com.pwhl.mobile.shared.standings.StandingsScreen
import kotlinx.serialization.Serializable

@Serializable
enum class Screen(
    val route: String,
    val title: String,
    val render: @Composable (Modifier, NavController) -> Unit,
) {
    Feed(
        route = "feed",
        title = "Feed",
        render = { modifier, navController ->
            FeedScreen(
                onGameClicked = { gameId ->
                    navController.navigate("game/$gameId")
                },
                modifier = modifier,
            )
        },
    ),
    News(
        route = "news",
        title = "News",
        render = { modifier, _ ->
            NewsScreen(modifier)
        },
    ),
    Standings(
        route = "standings",
        title = "Standings",
        render = { modifier, _ ->
            StandingsScreen(modifier)
        },
    ),
    Profile(
        route = "profile",
        title = "Profile",
        render = { modifier, _ ->
            ProfileScreen(modifier)
        },
    ),
    GameDetail(
        route = "game/{gameId}",
        title = "Game Detail",
        render = { modifier, _ ->
            GameDetailScreen(modifier)
        },
    ),
}
