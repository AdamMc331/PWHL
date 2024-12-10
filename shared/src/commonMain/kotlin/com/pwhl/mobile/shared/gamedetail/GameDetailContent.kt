package com.pwhl.mobile.shared.gamedetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pwhl.mobile.shared.ui.components.LoadingScreen

@Composable
fun GameDetailContent(
    state: GameDetailState,
    modifier: Modifier = Modifier,
) {
    if (state.isLoading) {
        LoadingScreen(modifier)
    } else {
        Text(
            text = "Game Detail Stub: ${state.game}",
            modifier = modifier,
        )
    }
}
