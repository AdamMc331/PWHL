package com.adammcneilly.pwhl.mobile.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.adammcneilly.pwhl.mobile.shared.feed.FeedScreen
import com.adammcneilly.pwhl.mobile.shared.gamedetail.GameDetailScreen
import com.adammcneilly.pwhl.mobile.shared.gamedetail.GameDetailViewModel
import com.adammcneilly.pwhl.mobile.shared.news.NewsScreen
import com.adammcneilly.pwhl.mobile.shared.profile.ProfileScreen
import com.adammcneilly.pwhl.mobile.shared.standings.StandingsScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

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
            )
        }

        composable<NewsScreen> {
            NewsScreen()
        }

        composable<StandingsScreen> {
            StandingsScreen()
        }

        composable<ProfileScreen> {
            ProfileScreen()
        }

        composable<GameDetailScreen> { backStackEntry ->
            val screen: GameDetailScreen = backStackEntry.toRoute()

            val viewModel: GameDetailViewModel = koinViewModel(
                parameters = {
                    parametersOf(screen.gameId)
                },
            )

            GameDetailScreen(
                viewModel = viewModel,
            )
        }
    }
}
