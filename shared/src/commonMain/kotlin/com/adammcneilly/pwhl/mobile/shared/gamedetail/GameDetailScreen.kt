package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.adammcneilly.pwhl.mobile.shared.ui.components.SpatialModeSwitchFAB
import kotlinx.serialization.Serializable
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
@OptIn(KoinExperimentalAPI::class)
fun GameDetailScreen(
    viewModel: GameDetailViewModel,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize(),
    ) {
        GameDetailContent(
            state = state.value,
        )

        SpatialModeSwitchFAB(
            modifier = Modifier
                .align(Alignment.BottomEnd),
        )
    }
}

@Serializable
data class GameDetailScreen(
    val gameId: String,
)
