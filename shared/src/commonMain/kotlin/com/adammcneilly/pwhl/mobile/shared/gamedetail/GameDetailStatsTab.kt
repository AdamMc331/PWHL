package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.adammcneilly.pwhl.mobile.shared.displaymodels.StatComparisonDisplayModel
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
            StatComparisonDisplayModel(
                stat = "Shots",
                homeTeamValue = "18",
                awayTeamValue = "12",
                homeTeamColor = Color.Red,
                awayTeamColor = Color.Blue,
                homeTeamPercentage = 18F / (18F + 12F),
            ),
            modifier = Modifier
                .fillMaxWidth(),
        )

        AnimatableStatComparison(
            StatComparisonDisplayModel(
                stat = "Assists",
                homeTeamValue = "2",
                awayTeamValue = "0",
                homeTeamColor = Color.Red,
                awayTeamColor = Color.Blue,
                homeTeamPercentage = 2F / (2F + 0F),
            ),
            modifier = Modifier
                .fillMaxWidth(),
        )

        AnimatableStatComparison(
            StatComparisonDisplayModel(
                stat = "Goals",
                homeTeamValue = "5",
                awayTeamValue = "2",
                homeTeamColor = Color.Red,
                awayTeamColor = Color.Blue,
                homeTeamPercentage = 5F / (5F + 2F),
            ),
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}
