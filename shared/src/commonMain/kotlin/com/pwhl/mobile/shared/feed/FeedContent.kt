package com.pwhl.mobile.shared.feed

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        item {
            Text(
                text = "Upcoming Games",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(8.dp),
            )
        }

        state.upcomingGames.entries.forEach { (dateString, games) ->
            item {
                Text(
                    text = dateString,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                        .padding(8.dp),
                )
            }

            itemsIndexed(games) { index, game ->
                GameListItem(game)

                if (index != games.lastIndex) {
                    HorizontalDivider()
                }
            }
        }

        item {
            Text(
                text = "Recent Games",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(8.dp),
            )
        }

        state.recentGames.entries.forEach { (dateString, games) ->
            item {
                Text(
                    text = dateString,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                        .padding(8.dp),
                )
            }

            itemsIndexed(games) { index, game ->
                GameListItem(game)

                if (index != games.lastIndex) {
                    HorizontalDivider()
                }
            }
        }
    }
}
