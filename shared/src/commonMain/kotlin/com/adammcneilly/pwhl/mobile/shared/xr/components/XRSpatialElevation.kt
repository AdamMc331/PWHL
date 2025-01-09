package com.adammcneilly.pwhl.mobile.shared.xr.components

import androidx.compose.runtime.Composable

@Composable
expect fun XRSpatialElevation(
    spatialElevationLevel: XRSpatialElevationLevel = XRSpatialElevationLevel.One,
    content: @Composable () -> Unit,
)
