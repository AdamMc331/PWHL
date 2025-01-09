package com.adammcneilly.pwhl.mobile.shared.xr.components

import androidx.compose.runtime.Composable
import androidx.xr.compose.spatial.SpatialElevation
import androidx.xr.compose.spatial.SpatialElevationLevel

@Composable
actual fun XRSpatialElevation(
    spatialElevationLevel: XRSpatialElevationLevel,
    content: @Composable (() -> Unit),
) {
    SpatialElevation(
        spatialElevationLevel = spatialElevationLevel.toSpatialElevationLevel(),
        content = content,
    )
}

private fun XRSpatialElevationLevel.toSpatialElevationLevel(): SpatialElevationLevel {
    return when (this) {
        XRSpatialElevationLevel.Zero -> SpatialElevationLevel.Level0
        XRSpatialElevationLevel.One -> SpatialElevationLevel.Level1
        XRSpatialElevationLevel.Two -> SpatialElevationLevel.Level2
        XRSpatialElevationLevel.Three -> SpatialElevationLevel.Level3
        XRSpatialElevationLevel.Four -> SpatialElevationLevel.Level4
        XRSpatialElevationLevel.Five -> SpatialElevationLevel.Level5
    }
}
