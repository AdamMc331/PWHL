package com.pwhl.mobile.shared.gamedetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
@OptIn(KoinExperimentalAPI::class)
fun GameDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: GameDetailViewModel = koinNavViewModel(),
) {
    val state = viewModel.state.collectAsState()

    GameDetailContent(
        state = state.value,
        modifier = modifier,
    )
}

@Serializable
data class GameDetailScreen(
    val gameId: String,
)
