package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.adammcneilly.pwhl.mobile.shared.ui.components.AnimatableStatComparison
import com.adammcneilly.pwhl.mobile.shared.ui.theme.PWHLTheme

@Composable
fun GameDetailStatsTab(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(PWHLTheme.dimensions.componentPadding),
    ) {
        AnimatableStatComparison(
            homeTeamValue = 5,
            awayTeamValue = 4,
            homeTeamColor = Color.Red,
            awayTeamColor = Color.Blue,
            modifier = Modifier
                .fillMaxWidth(),
        )

        AnimatableStatComparison(
            homeTeamValue = 4,
            awayTeamValue = 4,
            homeTeamColor = Color.Red,
            awayTeamColor = Color.Blue,
            modifier = Modifier
                .fillMaxWidth(),
        )

        AnimatableStatComparison(
            homeTeamValue = 1,
            awayTeamValue = 8,
            homeTeamColor = Color.Red,
            awayTeamColor = Color.Blue,
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}
