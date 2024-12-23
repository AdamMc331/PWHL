package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameDetailDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.gamedetail.xr.ImmersiveGameDetailContent
import com.adammcneilly.pwhl.mobile.shared.ui.components.LoadingScreen
import com.adammcneilly.pwhl.mobile.shared.xr.LocalXRSession

@Composable
fun GameDetailContent(
    state: GameDetailState,
    modifier: Modifier = Modifier,
) {
    if (LocalXRSession.current?.isSpatialUiEnabled == true) {
        ImmersiveGameDetailContent(state)
    } else {
        NonImmersiveContent(state, modifier)
    }
}

@Composable
private fun NonImmersiveContent(
    state: GameDetailState,
    modifier: Modifier,
) {
    when {
        state.isLoading -> {
            LoadingScreen(
                modifier = modifier,
            )
        }

        state.game != null -> {
            SuccessContent(
                game = state.game,
                playByPlayEvents = state.playByPlayEvents,
                modifier = modifier,
            )
        }

        else -> {
            Text(
                text = "Something went wrong.",
                modifier = modifier,
            )
        }
    }
}

@Composable
private fun SuccessContent(
    game: GameDetailDisplayModel,
    playByPlayEvents: Map<String, List<PlayByPlayEventDisplayModel>>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        GameDetailHeader(
            game = game,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )

        GameDetailPager(
            game = game,
            playByPlayEvents = playByPlayEvents,
            modifier = Modifier
                .fillMaxSize(),
        )
    }
}
