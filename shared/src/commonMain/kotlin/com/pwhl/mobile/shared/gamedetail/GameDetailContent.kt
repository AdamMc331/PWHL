package com.pwhl.mobile.shared.gamedetail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pwhl.mobile.shared.ui.components.LoadingScreen
import com.pwhl.mobile.shared.ui.components.PWHLScreenScaffold

@Composable
fun GameDetailContent(
    state: GameDetailState,
    modifier: Modifier = Modifier,
) {
    val title = if (state.isLoading) {
        "Game Detail"
    } else {
        state.teamMatchUp
    }

    PWHLScreenScaffold(
        title = title,
        modifier = modifier,
    ) { scaffoldPadding ->
        if (state.isLoading) {
            LoadingScreen(
                modifier = modifier
                    .padding(scaffoldPadding),
            )
        } else {
            Text(
                text = "Game Detail Stub: ${state.game}",
                modifier = modifier
                    .padding(scaffoldPadding),
            )
        }
    }
}
