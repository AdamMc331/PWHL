package com.adammcneilly.pwhl.mobile.shared.ui.components

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.xr.compose.subspace.SpatialPanel
import androidx.xr.compose.subspace.layout.SubspaceModifier

@Composable
fun SpatialSurface(
    modifier: SubspaceModifier = SubspaceModifier,
    content: @Composable () -> Unit,
) {
    SpatialPanel(
        modifier = modifier,
    ) {
        Surface {
            content()
        }
    }
}
