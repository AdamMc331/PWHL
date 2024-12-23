package com.adammcneilly.pwhl.mobile.shared.gamedetail.xr

import androidx.compose.runtime.Composable
import com.adammcneilly.pwhl.mobile.shared.gamedetail.GameDetailState

@Composable
expect fun ImmersiveGameDetailContent(
    state: GameDetailState,
)
