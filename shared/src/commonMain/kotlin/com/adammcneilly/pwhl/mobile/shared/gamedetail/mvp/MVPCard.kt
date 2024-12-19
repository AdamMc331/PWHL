package com.adammcneilly.pwhl.mobile.shared.gamedetail.mvp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.displaymodels.ImageDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.MostValuablePlayerDisplayModel
import com.adammcneilly.pwhl.mobile.shared.ui.components.ImageWrapper

@Composable
fun MVPCard(
    mvp: MostValuablePlayerDisplayModel,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                PlayerImage(mvp)

                PlayerInfo(mvp)
            }
        }
    }
}

@Composable
private fun PlayerInfo(
    mvp: MostValuablePlayerDisplayModel,
) {
    Column {
        PlayerName(mvp)

        PlayerSubtitle(mvp)
    }
}

@Composable
private fun PlayerName(
    mvp: MostValuablePlayerDisplayModel,
) {
    Text(
        text = mvp.player.fullName,
        style = MaterialTheme.typography.titleSmall,
    )
}

@Composable
private fun PlayerSubtitle(
    mvp: MostValuablePlayerDisplayModel,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        with(LocalDensity.current) {
            ImageWrapper(
                image = mvp.team.image,
                contentDescription = mvp.team.name,
                modifier = Modifier
                    .size(LocalTextStyle.current.fontSize.toDp()),
            )
        }

        val subtitle = "#${mvp.player.jerseyNumber} • ${mvp.player.position}"

        Text(
            text = subtitle,
        )
    }
}

@Composable
private fun PlayerImage(
    mvp: MostValuablePlayerDisplayModel,
) {
    ImageWrapper(
        image = mvp.player.playerImage ?: ImageDisplayModel.Placeholder,
        contentDescription = mvp.player.fullName,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape),
    )
}
