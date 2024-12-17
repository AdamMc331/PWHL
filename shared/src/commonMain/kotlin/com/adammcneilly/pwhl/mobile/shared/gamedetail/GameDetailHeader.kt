package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameSummaryDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.TeamDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.TeamGameResultDisplayModelV2
import com.adammcneilly.pwhl.mobile.shared.ui.components.ImageWrapper

@Composable
fun GameDetailHeader(
    game: GameSummaryDisplayModel,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        TeamNameLogo(game.homeTeam.team)

        TeamScore(game.homeTeam)

        GameSummary(game)

        TeamScore(game.awayTeam)

        TeamNameLogo(game.awayTeam.team)
    }
}

@Composable
private fun GameSummary(
    game: GameSummaryDisplayModel,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Text(
            text = game.status,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(0.50F),
        )

        Text(
            text = game.dateString,
        )
    }
}

@Composable
private fun TeamScore(
    teamGameResult: TeamGameResultDisplayModelV2,
) {
    Text(
        text = teamGameResult.stats.goals,
        style = MaterialTheme.typography.displayMedium,
    )
}

@Composable
private fun TeamNameLogo(
    team: TeamDisplayModel,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        ImageWrapper(
            image = team.image,
            contentDescription = team.name,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
        )

        Text(
            text = team.shortCode,
            style = MaterialTheme.typography.titleSmall,
        )
    }
}
