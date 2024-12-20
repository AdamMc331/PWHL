package com.adammcneilly.pwhl.mobile.shared.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloseFullscreen
import androidx.compose.material.icons.filled.OpenInFull
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.xr.LocalXRSession

@Composable
fun SpatialModeSwitchFAB(
    modifier: Modifier = Modifier,
) {
    val xrSession = LocalXRSession.current ?: return

    val hasSpatialUi = xrSession.isSpatialUiEnabled

    FloatingActionButton(
        onClick = {
            if (hasSpatialUi) {
                xrSession.requestHomeSpaceMode()
            } else {
                xrSession.requestFullSpaceMode()
            }
        },
        modifier = modifier
            .padding(32.dp),
    ) {
        Icon(
            imageVector = if (hasSpatialUi) {
                Icons.Default.CloseFullscreen
            } else {
                Icons.Default.OpenInFull
            },
            contentDescription = if (hasSpatialUi) {
                "Exit Full Space Mode"
            } else {
                "Enter Full Space Mode"
            },
        )
    }
}
