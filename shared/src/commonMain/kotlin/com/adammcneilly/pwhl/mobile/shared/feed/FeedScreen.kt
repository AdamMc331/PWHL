package com.adammcneilly.pwhl.mobile.shared.feed

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.adammcneilly.pwhl.mobile.shared.ui.components.PWHLScreenScaffold
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

/**
 * Stateful component for [FeedContent] that observes the state
 * from the supplied [viewModel].
 */
@Composable
@OptIn(KoinExperimentalAPI::class)
fun FeedScreen(
    onGameClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: FeedViewModel = koinViewModel(),
) {
    val state = viewModel.state.collectAsState()

    PWHLScreenScaffold(
        title = "Feed",
        modifier = modifier,
    ) { scaffoldPadding ->
        FeedContent(
            state = state.value,
            onGameClicked = onGameClicked,
            contentPadding = scaffoldPadding,
        )
    }
}

/**
 * Serializable route to the feed screen for Compose navigation.
 */
@Serializable
object FeedScreen
