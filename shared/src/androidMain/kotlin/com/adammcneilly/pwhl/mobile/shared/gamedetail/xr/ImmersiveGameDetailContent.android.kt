package com.adammcneilly.pwhl.mobile.shared.gamedetail.xr

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.xr.compose.spatial.Subspace
import androidx.xr.compose.subspace.SpatialColumn
import androidx.xr.compose.subspace.SpatialRow
import androidx.xr.compose.subspace.layout.SubspaceModifier
import androidx.xr.compose.subspace.layout.fillMaxWidth
import androidx.xr.compose.subspace.layout.width
import com.adammcneilly.pwhl.mobile.shared.gamedetail.GameDetailState
import com.adammcneilly.pwhl.mobile.shared.ui.components.SpatialSurface

@Composable
actual fun ImmersiveGameDetailContent(
    state: GameDetailState,
) {
    Subspace {
        SpatialColumn(
            modifier = SubspaceModifier
                .width(1200.dp), // Determine where this number came from and how to set a practical default
        ) {
            if (state.game != null) {
                SpatialSurface(
                    modifier = SubspaceModifier
                        .fillMaxWidth(),
                ) {
                    SpatialGameDetailHeader(
                        game = state.game,
                    )
                }
            }

            SpatialRow {
                SpatialSurface {
                    Text("MVP Content")
                }

                SpatialSurface {
                    Text("Stat Content")
                }

                SpatialSurface {
                    Text("PBP Content")
                }
            }
        }
    }
}
