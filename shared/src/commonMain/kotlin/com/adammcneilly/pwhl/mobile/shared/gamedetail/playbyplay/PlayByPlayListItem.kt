package com.adammcneilly.pwhl.mobile.shared.gamedetail.playbyplay

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.ui.components.ImageWrapper
import com.adammcneilly.pwhl.mobile.shared.ui.theme.PWHLTeamTheme

@Composable
fun PlayByPlayListItem(
    event: PlayByPlayEventDisplayModel,
    modifier: Modifier = Modifier,
) {
    PWHLTeamTheme(
        teamId = event.highlightTeamId,
    ) {
        val containerColor = if (event.highlightTeamId.isNotEmpty()) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.surface
        }

        Surface(
            color = containerColor,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = modifier
                    .padding(8.dp),
            ) {
                TeamImage(event)

                EventInfo(
                    event = event,
                    modifier = Modifier
                        .weight(1F),
                )

                Text(
                    text = event.time,
                )
            }
        }
    }
}

@Composable
private fun EventInfo(
    event: PlayByPlayEventDisplayModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = event.title,
            style = MaterialTheme.typography.titleMedium,
        )

        Text(
            text = event.description,
        )
    }
}

@Composable
private fun TeamImage(
    event: PlayByPlayEventDisplayModel,
) {
    ImageWrapper(
        image = event.teamImage,
        contentDescription = null,
        modifier = Modifier
            .size(36.dp),
    )
}
