package com.pwhl.mobile.shared.gamedetail

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.pwhl.mobile.shared.ui.components.PWHLScreenScaffold
import kotlinx.serialization.Serializable
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
@OptIn(KoinExperimentalAPI::class)
fun GameDetailScreen(
    viewModel: GameDetailViewModel,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    PWHLScreenScaffold(
        title = "Game Detail",
        modifier = modifier,
    ) { scaffoldPadding ->
        GameDetailContent(
            state = state.value,
            modifier = modifier
                .padding(scaffoldPadding),
        )
    }
}

@Serializable
data class GameDetailScreen(
    val gameId: String,
)
