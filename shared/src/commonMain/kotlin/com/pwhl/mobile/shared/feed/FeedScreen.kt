package com.pwhl.mobile.shared.feed

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
@OptIn(KoinExperimentalAPI::class)
fun FeedScreen(
    onGameClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: FeedViewModel = koinNavViewModel(),
) {
    val state = viewModel.state.collectAsState()

    FeedContent(
        state = state.value,
        onGameClicked = onGameClicked,
        modifier = modifier,
    )
}

@Serializable
object FeedScreen
