package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameDetailDisplayModel
import com.adammcneilly.pwhl.mobile.shared.gamedetail.mvp.MVPCard
import com.adammcneilly.pwhl.mobile.shared.ui.components.AnimatableStatComparison

@Composable
fun GameDetailSummaryTab(
    game: GameDetailDisplayModel,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        mvpSection(game)

        statComparisonSection(game)
    }
}

private fun LazyListScope.statComparisonSection(
    game: GameDetailDisplayModel,
) {
    val statComparisons = game.getTeamStatComparisons()

    statComparisons.forEach { statComparison ->
        item {
            AnimatableStatComparison(
                statComparison = statComparison,
            )
        }
    }
}

private fun LazyListScope.mvpSection(
    game: GameDetailDisplayModel,
) {
    if (game.mostValuablePlayers.isEmpty()) {
        return
    }

    item {
        Column {
            Text(
                text = "Most Valuable Players",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp,
                    ),
            )

            LazyRow(
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                ),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(game.mostValuablePlayers) { mvp ->
                    MVPCard(
                        mvp = mvp,
                    )
                }
            }
        }
    }
}
