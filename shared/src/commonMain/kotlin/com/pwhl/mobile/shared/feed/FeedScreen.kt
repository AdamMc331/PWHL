package com.pwhl.mobile.shared.feed

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.pwhl.mobile.shared.ui.components.GameListItem
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel: FeedViewModel = koinViewModel()
    viewModel.fetchData()
    val state = viewModel.state.collectAsState()

    LazyColumn {
        items(state.value.recentGames) { game ->
            GameListItem(game)

            HorizontalDivider()
        }
    }
}
