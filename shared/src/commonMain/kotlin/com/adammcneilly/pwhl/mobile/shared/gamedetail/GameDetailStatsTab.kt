package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.pwhl.mobile.shared.ui.components.AnimatableStatComparison
import com.adammcneilly.pwhl.mobile.shared.ui.theme.PWHLColors

@Composable
fun GameDetailStatsTab(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        AnimatableStatComparison(
            homeTeamValue = 5,
            awayTeamValue = 4,
            homeTeamColor = PWHLColors.NewYork,
            awayTeamColor = PWHLColors.Minnesota,
            modifier = Modifier
                .fillMaxWidth(),
        )

        AnimatableStatComparison(
            homeTeamValue = 5,
            awayTeamValue = 4,
            homeTeamColor = PWHLColors.NewYork,
            awayTeamColor = PWHLColors.Minnesota,
            modifier = Modifier
                .fillMaxWidth(),
        )

        AnimatableStatComparison(
            homeTeamValue = 5,
            awayTeamValue = 4,
            homeTeamColor = PWHLColors.NewYork,
            awayTeamColor = PWHLColors.Minnesota,
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}
