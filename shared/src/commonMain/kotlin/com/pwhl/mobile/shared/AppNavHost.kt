package com.pwhl.mobile.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pwhl.mobile.shared.feed.FeedScreen
import com.pwhl.mobile.shared.gamedetail.GameDetailScreen
import com.pwhl.mobile.shared.news.NewsScreen
import com.pwhl.mobile.shared.profile.ProfileScreen
import com.pwhl.mobile.shared.standings.StandingsScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = FeedScreen,
        modifier = modifier,
    ) {
        composable<FeedScreen> {
            FeedScreen(
                onGameClicked = { gameId ->
                    navController.navigate(GameDetailScreen(gameId))
                },
                viewModel = koinViewModel(),
            )
        }

        composable<NewsScreen> {
            NewsScreen()
        }

        composable<StandingsScreen> {
            StandingsScreen(
                viewModel = koinViewModel(),
            )
        }

        composable<ProfileScreen> {
            ProfileScreen()
        }

        composable<GameDetailScreen> {
            GameDetailScreen()
        }
    }
}
