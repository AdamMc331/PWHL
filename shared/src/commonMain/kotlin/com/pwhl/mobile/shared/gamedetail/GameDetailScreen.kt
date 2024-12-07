package com.pwhl.mobile.shared.gamedetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: GameDetailViewModel = koinViewModel(),
) {
    val state = viewModel.state.collectAsState()

    GameDetailContent(
        state = state.value,
        modifier = modifier,
    )
}
