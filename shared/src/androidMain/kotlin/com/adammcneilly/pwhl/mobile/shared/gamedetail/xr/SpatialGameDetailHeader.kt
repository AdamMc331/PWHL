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

@Composable
fun ImmersiveGameDetailHeader(
    game: GameDetailDisplayModel,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(PWHLTheme.dimensions.componentVerticalPadding),
        modifier = modifier
            .padding(PWHLTheme.dimensions.componentPadding),
    ) {
        TeamScores(game)

        GameSummary(game)
    }
}

@Composable
private fun TeamScores(
    game: GameDetailDisplayModel,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TeamNameLogo(
                team = game.homeTeam.team,
            )

            TeamScore(
                teamGameResult = game.homeTeam,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TeamScore(
                teamGameResult = game.awayTeam,
            )

            TeamNameLogo(
                team = game.awayTeam.team,
            )
        }
    }
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun GameSummary(
    game: GameDetailDisplayModel,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Text(
            text = game.status,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
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
