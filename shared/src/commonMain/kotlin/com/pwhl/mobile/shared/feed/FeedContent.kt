package com.pwhl.mobile.shared.feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pwhl.mobile.shared.ui.components.GameListItem
import com.pwhl.mobile.shared.ui.components.LoadingScreen

@Composable
fun FeedContent(
    state: FeedState,
    onGameClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (state.loadingRecentGames || state.loadingUpcomingGames) {
        LoadingScreen(modifier)
    } else {
        SuccessContent(
            state = state,
            onGameClicked = onGameClicked,
            modifier = modifier,
        )
    }
}

@Composable
private fun SuccessContent(
    state: FeedState,
    onGameClicked: (String) -> Unit,
    modifier: Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(state.recentGames) { game ->
            GameListItem(
                game = game,
                modifier = Modifier
                    .clickable(
                        onClick = {
                            onGameClicked(game.id)
                        },
                    ),
            )

            HorizontalDivider()
        }

        items(state.upcomingGames) { game ->
            GameListItem(game)

            HorizontalDivider()
        }
    }
}
