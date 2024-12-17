package com.adammcneilly.pwhl.mobile.shared.standings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.displaymodels.StandingsRowDisplayModel
import com.adammcneilly.pwhl.mobile.shared.ui.components.ImageWrapper

@Composable
fun StandingsRowListItem(
    standingsRow: StandingsRowDisplayModel,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(16.dp),
    ) {
        Text(
            text = standingsRow.rank.toString(),
            style = MaterialTheme.typography.titleLarge,
        )

        ImageWrapper(
            image = standingsRow.team.image,
            contentDescription = null,
            modifier = Modifier
                .size(36.dp),
        )

        Column {
            Text(
                text = standingsRow.team.name,
                fontWeight = FontWeight.Bold,
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
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
        )
    }
}
