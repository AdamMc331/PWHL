package com.adammcneilly.pwhl.mobile.shared.gamedetail.xr

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.xr.compose.subspace.SpatialRow
import androidx.xr.compose.subspace.layout.SubspaceModifier
import androidx.xr.compose.subspace.layout.fillMaxWidth
import androidx.xr.compose.subspace.layout.height
import androidx.xr.compose.subspace.layout.padding
import androidx.xr.compose.subspace.layout.width
import com.adammcneilly.pwhl.mobile.shared.gamedetail.GameDetailState
import com.adammcneilly.pwhl.mobile.shared.gamedetail.GameDetailStatsTab
import com.adammcneilly.pwhl.mobile.shared.gamedetail.GameDetailSummaryTab
import com.adammcneilly.pwhl.mobile.shared.gamedetail.playbyplay.PlayByPlayList
import com.adammcneilly.pwhl.mobile.shared.ui.components.SpatialSurface
import com.adammcneilly.pwhl.mobile.shared.xr.XRSession

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
        SpatialColumn(
            modifier = SubspaceModifier
                .width(1200.dp), // Determine where this number came from and how to set a practical default
        ) {
            SpatialSurface(
                modifier = SubspaceModifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
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
                                session.requestHomeSpaceMode()
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

                SpatialGameDetailHeader(
                    game = state.game,
                )
            }

            SpatialRow(
                modifier = SubspaceModifier
                    .width(1200.dp), // Determine where this number came from and how to set a practical default
            ) {
                SpatialSurface(
                    modifier = SubspaceModifier
                        .height(600.dp)
                        .weight(1F),
                ) {
                    GameDetailSummaryTab(
                        game = state.game,
                    )
                }

                SpatialSurface(
                    modifier = SubspaceModifier
                        .height(600.dp)
                        .weight(1F)
                        .padding(horizontal = 16.dp),
                ) {
                    GameDetailStatsTab()
                }

                SpatialSurface(
                    modifier = SubspaceModifier
                        .height(600.dp)
                        .weight(1F),
                ) {
                    PlayByPlayList(
                        events = state.playByPlayEvents,
                    )
                }
            }
        }
    }
}
