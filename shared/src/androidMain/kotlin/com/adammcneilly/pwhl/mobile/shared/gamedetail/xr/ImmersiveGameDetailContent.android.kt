package com.adammcneilly.pwhl.mobile.shared.gamedetail.xr

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
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

@Composable
actual fun ImmersiveGameDetailContent(
    state: GameDetailState,
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
