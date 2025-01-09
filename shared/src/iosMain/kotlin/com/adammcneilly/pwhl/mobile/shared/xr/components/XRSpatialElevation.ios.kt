package com.adammcneilly.pwhl.mobile.shared.xr.components

import androidx.compose.runtime.Composable

@Composable
actual fun XRSpatialElevation(
    spatialElevationLevel: XRSpatialElevationLevel,
    content: @Composable (() -> Unit),
) {
    // Not implemented for iOS
}
