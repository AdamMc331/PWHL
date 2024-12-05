package com.pwhl.mobile.shared.standings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.pwhl.mobile.shared.displaymodels.StandingsRowDisplayModel
import com.pwhl.mobile.shared.ui.components.ImageWrapper

@Composable
fun StandingsRowListItem(
    standingsRow: StandingsRowDisplayModel,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        Text(
            text = standingsRow.rank.toString(),
        )

        ImageWrapper(
            image = standingsRow.team.image,
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
        )

        Column {
            Text(
                text = standingsRow.team.name,
            )

            Text(
                text = standingsRow.record,
            )
        }

        Spacer(
            modifier = Modifier
                .weight(1F),
        )

        Text(
            text = "${standingsRow.points} Points",
        )
    }
}
