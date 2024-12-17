package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.LocalNavAnimatedVisibilityScope
import com.adammcneilly.pwhl.mobile.shared.LocalSharedTransitionScope
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
        TeamNameLogo(
            team = game.homeTeam.team,
            gameId = game.id,
        )

        TeamScore(game.homeTeam)

        GameSummary(game)

        TeamScore(game.awayTeam)

        TeamNameLogo(
            team = game.awayTeam.team,
            gameId = game.id,
        )
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
@OptIn(ExperimentalSharedTransitionApi::class)
private fun TeamNameLogo(
    team: TeamDisplayModel,
    gameId: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        with(LocalSharedTransitionScope.current) {
            ImageWrapper(
                image = team.image,
                contentDescription = team.name,
                modifier = Modifier
                    .size(48.dp)
                    .sharedElement(
                        state = rememberSharedContentState(key = "${team.name}_${gameId}_image"),
                        animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current,
                    ),
            )

            Text(
                text = team.shortCode,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .sharedBounds(
                        sharedContentState = rememberSharedContentState(key = "${team.name}_${gameId}_name"),
                        animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current,
                        resizeMode = SharedTransitionScope.ResizeMode.ScaleToBounds(),
                    ),
            )
        }
    }
}
