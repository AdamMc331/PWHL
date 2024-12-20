package com.adammcneilly.pwhl.mobile.shared.xr

import androidx.compose.runtime.Composable
import androidx.xr.compose.platform.LocalSession
import androidx.xr.compose.platform.LocalSpatialCapabilities
import androidx.xr.scenecore.Session

@Composable
actual fun currentXRSession(): XRSession? {
    return LocalSession.current?.let(::AndroidXRSession)
}

class AndroidXRSession(
    val xrSession: Session,
) : XRSession {
    override val isSpatialUiEnabled: Boolean
        @Composable get() = LocalSpatialCapabilities.current.isSpatialUiEnabled

    override fun requestHomeSpaceMode() {
        xrSession.requestHomeSpaceMode()
    }

    override fun requestFullSpaceMode() {
        xrSession.requestFullSpaceMode()
    }
}
