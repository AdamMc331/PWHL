package com.adammcneilly.pwhl.mobile.shared.xr.components

import androidx.compose.runtime.Composable

enum class XRSpatialElevationLevel {
    Zero,
    One,
    Two,
    Three,
    Four,
    Five,
}

@Composable
expect fun XRSpatialElevation(
    spatialElevationLevel: XRSpatialElevationLevel = XRSpatialElevationLevel.One,
    content: @Composable () -> Unit,
)
