package com.pwhl.mobile.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pwhl.mobile.shared.feed.FeedScreen

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
}
