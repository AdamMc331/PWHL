package com.pwhl.mobile.shared.gamedetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GameDetailContent(
    state: GameDetailState,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Game Detail Stub: ${state.game}",
        modifier = modifier,
    )
}
