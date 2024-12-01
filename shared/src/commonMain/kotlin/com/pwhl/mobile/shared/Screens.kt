package com.pwhl.mobile.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pwhl.mobile.shared.feed.FeedScreen

enum class Screens(
    val route: String,
    val render: @Composable (Modifier) -> Unit,
) {
    Feed(
        route = "feed",
        render = { modifier ->
            FeedScreen(modifier)
        },
    ),
}
