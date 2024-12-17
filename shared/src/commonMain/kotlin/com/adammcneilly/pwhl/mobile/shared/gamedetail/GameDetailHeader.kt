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

        TeamScore(
            teamGameResult = game.homeTeam,
            gameId = game.id,
        )

        GameSummary(game)

        TeamScore(
            teamGameResult = game.awayTeam,
            gameId = game.id,
        )

        TeamNameLogo(
            team = game.awayTeam.team,
            gameId = game.id,
        )
    }
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun GameSummary(
    game: GameSummaryDisplayModel,
    modifier: Modifier = Modifier,
) {
    with(LocalSharedTransitionScope.current) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier,
        ) {
            Text(
                text = game.status,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .sharedBounds(
                        sharedContentState = rememberSharedContentState(key = "${game.id}_status"),
                        animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current,
                        resizeMode = SharedTransitionScope.ResizeMode.ScaleToBounds(),
                    ),
            )

            Text(
                text = game.dateString,
                modifier = Modifier
                    .sharedBounds(
                        sharedContentState = rememberSharedContentState(key = "game_date_${game.dateString}"),
                        animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current,
                        resizeMode = SharedTransitionScope.ResizeMode.ScaleToBounds(),
                    ),
            )
        }
    }
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun TeamScore(
    teamGameResult: TeamGameResultDisplayModelV2,
    gameId: String,
) {
    with(LocalSharedTransitionScope.current) {
        Text(
            text = teamGameResult.stats.goals,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .sharedBounds(
                    sharedContentState = rememberSharedContentState(
                        key = "${teamGameResult.team.name}_${gameId}_score",
                    ),
                    animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current,
                    resizeMode = SharedTransitionScope.ResizeMode.ScaleToBounds(),
                ),
        )
    }
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
