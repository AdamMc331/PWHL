package com.adammcneilly.pwhl.mobile.shared.xr

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf

@Composable
expect fun currentXRSession(): XRSession?

val LocalXRSession = compositionLocalOf<XRSession?> {
    null
}

interface XRSession {
    val isSpatialUiEnabled: Boolean
        @Composable get

    fun requestHomeSpaceMode()

    fun requestFullSpaceMode()
}
