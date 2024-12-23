package com.adammcneilly.pwhl.mobile.shared.gamedetail.xr

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameDetailDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.TeamDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.TeamGameDetailResultDisplayModel
import com.adammcneilly.pwhl.mobile.shared.ui.components.ImageWrapper
import com.adammcneilly.pwhl.mobile.shared.ui.theme.PWHLTheme

private const val GAME_STATUS_WIDTH_RATIO = 0.50F

@Composable
fun SpatialGameDetailHeader(
    game: GameDetailDisplayModel,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(32.dp),
    ) {
        TeamNameLogo(
            team = game.homeTeam.team,
        )

        TeamScore(
            teamGameResult = game.homeTeam,
        )

        GameSummary(game)

        TeamScore(
            teamGameResult = game.awayTeam,
        )

        TeamNameLogo(
            team = game.awayTeam.team,
        )
    }
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun GameSummary(
    game: GameDetailDisplayModel,
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
                .fillMaxWidth(GAME_STATUS_WIDTH_RATIO),
        )

        Text(
            text = game.dateString,
        )
    }
}

@Composable
private fun TeamScore(
    teamGameResult: TeamGameDetailResultDisplayModel,
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
                .size(PWHLTheme.dimensions.imageSizeDefault),
        )

        Text(
            text = team.shortCode,
            style = MaterialTheme.typography.titleSmall,
        )
    }
}
