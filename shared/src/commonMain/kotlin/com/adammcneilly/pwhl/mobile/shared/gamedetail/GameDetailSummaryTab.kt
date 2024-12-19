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
import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameSummaryDisplayModel
import com.adammcneilly.pwhl.mobile.shared.gamedetail.mvp.MVPCard

@Composable
fun GameDetailSummaryTab(
    game: GameSummaryDisplayModel,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        mvpSection(game)
    }
}

private fun LazyListScope.mvpSection(
    game: GameSummaryDisplayModel,
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
