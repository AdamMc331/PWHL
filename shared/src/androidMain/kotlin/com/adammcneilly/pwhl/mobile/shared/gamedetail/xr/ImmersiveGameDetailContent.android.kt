package com.adammcneilly.pwhl.mobile.shared.gamedetail.xr

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloseFullscreen
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.xr.compose.spatial.EdgeOffset.Companion.inner
import androidx.xr.compose.spatial.Orbiter
import androidx.xr.compose.spatial.OrbiterEdge
import androidx.xr.compose.spatial.Subspace
import androidx.xr.compose.subspace.SpatialColumn
import androidx.xr.compose.subspace.SpatialPanel
import androidx.xr.compose.subspace.SpatialRow
import androidx.xr.compose.subspace.layout.SpatialRoundedCornerShape
import androidx.xr.compose.subspace.layout.SubspaceModifier
import androidx.xr.compose.subspace.layout.fillMaxWidth
import androidx.xr.compose.subspace.layout.height
import androidx.xr.compose.subspace.layout.padding
import androidx.xr.compose.subspace.layout.width
import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameDetailDisplayModel
import com.adammcneilly.pwhl.mobile.shared.gamedetail.GameDetailState
import com.adammcneilly.pwhl.mobile.shared.gamedetail.GameDetailStatsTab
import com.adammcneilly.pwhl.mobile.shared.gamedetail.playbyplay.PlayByPlayList
import com.adammcneilly.pwhl.mobile.shared.ui.components.PlayerHighlightCard
import com.adammcneilly.pwhl.mobile.shared.ui.components.SpatialSurface
import com.adammcneilly.pwhl.mobile.shared.xr.XRSession

private val IMMERSIVE_GAME_DETAIL_WIDTH = 1400.dp
private val IMMERSIVE_DETAIL_PANEL_HEIGHT = 1000.dp

@Composable
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
actual fun ImmersiveGameDetailContent(
    state: GameDetailState,
    xrSession: XRSession,
) {
    if (state.game == null) {
        // Need to handle loading/error state.
        // Ideally we don't even allow entering immersive UI without game.
        return
    }

    Subspace {
        SpatialRow(
            modifier = SubspaceModifier
                .width(IMMERSIVE_GAME_DETAIL_WIDTH),
        ) {
            StatsPanel(
                modifier = SubspaceModifier
                    .height(IMMERSIVE_DETAIL_PANEL_HEIGHT)
                    .weight(1F),
            )

            SpatialColumn(
                modifier = SubspaceModifier
                    .height(IMMERSIVE_DETAIL_PANEL_HEIGHT)
                    .weight(1F)
                    .padding(
                        horizontal = 16.dp,
                    ),
            ) {
                Header(
                    xrSession = xrSession,
                    game = state.game,
                )

                MVPPanel(
                    game = state.game,
                    modifier = SubspaceModifier
                        .weight(1F),
                )
            }

            PlayByPlayPanel(
                state = state,
                modifier = SubspaceModifier
                    .height(IMMERSIVE_DETAIL_PANEL_HEIGHT)
                    .weight(1F),
            )
        }
    }
}

@Composable
private fun Header(
    xrSession: XRSession,
    game: GameDetailDisplayModel,
    modifier: SubspaceModifier = SubspaceModifier,
) {
    SpatialSurface(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
    ) {
        EnterHomeSpaceButton(xrSession)

        ImmersiveGameDetailHeader(
            game = game,
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
private fun EnterHomeSpaceButton(
    xrSession: XRSession,
) {
    Orbiter(
        position = OrbiterEdge.Top,
        offset = inner(8.dp),
        alignment = Alignment.End,
    ) {
        Surface(
            shape = CircleShape,
            modifier = Modifier
                .padding(end = 16.dp),
        ) {
            IconButton(
                onClick = {
                    xrSession.requestHomeSpaceMode()
                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                ),
                modifier = Modifier
                    .size(IconButtonDefaults.mediumContainerSize()),
            ) {
                Icon(
                    imageVector = Icons.Default.CloseFullscreen,
                    contentDescription = "Exit Full Space Mode",
                )
            }
        }
    }
}

@Composable
private fun MVPPanel(
    game: GameDetailDisplayModel,
    modifier: SubspaceModifier = SubspaceModifier,
) {
    SpatialPanel(
        shape = SpatialRoundedCornerShape(ZeroCornerSize),
        modifier = modifier,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            game.mostValuablePlayers.forEach { mvp ->
                PlayerHighlightCard(
                    playerHighlight = mvp,
                    shape = MaterialTheme.shapes.extraLarge,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
        }
    }
}

@Composable
private fun StatsPanel(
    modifier: SubspaceModifier = SubspaceModifier,
) {
    SpatialSurface(
        modifier = modifier,
    ) {
        GameDetailStatsTab()
    }
}

@Composable
private fun PlayByPlayPanel(
    state: GameDetailState,
    modifier: SubspaceModifier = SubspaceModifier,
) {
    SpatialSurface(
        modifier = modifier,
    ) {
        PlayByPlayList(
            events = state.playByPlayEvents,
        )
    }
}
