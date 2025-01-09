package com.adammcneilly.pwhl.mobile.shared.gamedetail.xr

import androidx.compose.runtime.Composable
import com.adammcneilly.pwhl.mobile.shared.gamedetail.GameDetailState
import com.adammcneilly.pwhl.mobile.shared.gamedetail.GameDetailUiEvent
import com.adammcneilly.pwhl.mobile.shared.xr.XRSession

@Composable
expect fun ImmersiveGameDetailContent(
    state: GameDetailState,
    xrSession: XRSession,
    eventHandler: (GameDetailUiEvent) -> Unit,
)
