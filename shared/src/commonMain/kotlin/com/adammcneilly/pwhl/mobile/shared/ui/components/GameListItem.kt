package com.adammcneilly.pwhl.mobile.shared.ui.components

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.LocalNavAnimatedVisibilityScope
import com.adammcneilly.pwhl.mobile.shared.LocalSharedTransitionScope
import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.TeamGameResultDisplayModel

@Composable
fun GameListItem(
    game: GameDisplayModel,
    modifier: Modifier = Modifier,
) {
    Surface {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
                .padding(16.dp),
        ) {
            TeamRows(
                game = game,
                modifier = Modifier
                    .weight(2F),
            )

            Text(
                text = game.status,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1F),
            )
        }
    }
}

@Composable
private fun TeamRows(
    game: GameDisplayModel,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        TeamRow(
            teamGameResult = game.homeTeam,
            gameId = game.id,
        )

        TeamRow(
            teamGameResult = game.awayTeam,
            gameId = game.id,
        )
    }
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun TeamRow(
    teamGameResult: TeamGameResultDisplayModel,
    gameId: String,
) {
    val fontWeight = FontWeight.Bold.takeIf {
        teamGameResult.isWinner
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        with(LocalSharedTransitionScope.current) {
            val teamName = teamGameResult.team.name

            ImageWrapper(
                image = teamGameResult.team.image,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .sharedElement(
                        state = rememberSharedContentState(key = "${teamName}_${gameId}_image"),
                        animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current,
                    ),
            )
        }

        Spacer(
            modifier = Modifier
                .width(8.dp),
        )

        Text(
            text = teamGameResult.team.name,
            fontWeight = fontWeight,
        )

        Spacer(
            modifier = Modifier
                .weight(1F),
        )

        Text(
            text = teamGameResult.goals.toString(),
            fontWeight = fontWeight,
        )
    }
}
