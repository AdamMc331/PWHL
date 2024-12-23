@file:Suppress("MagicNumber")

package com.adammcneilly.pwhl.mobile.shared.gamedetail.mvp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.displaymodels.ImageDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.MostValuablePlayerDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.StatDisplayModel
import com.adammcneilly.pwhl.mobile.shared.ui.components.ImageWrapper
import com.adammcneilly.pwhl.mobile.shared.ui.theme.PWHLTheme
import com.adammcneilly.pwhl.mobile.shared.ui.util.currentWindowSizeClass

@Composable
fun MVPCard(
    mvp: MostValuablePlayerDisplayModel,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.large,
) {
    Card(
        shape = shape,
        modifier = modifier
            .width(IntrinsicSize.Max),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(PWHLTheme.dimensions.componentVerticalPadding),
            modifier = Modifier
                .padding(PWHLTheme.dimensions.componentPadding),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(PWHLTheme.dimensions.componentHorizontalPadding),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                PlayerImage(mvp)

                PlayerInfo(mvp)
            }

            Stats(mvp)
        }
    }
}

@Composable
private fun Stats(
    mvp: MostValuablePlayerDisplayModel,
) {
    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = MaterialTheme.shapes.large,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 8.dp,
                    vertical = 4.dp,
                ),
        ) {
            mvp.highlightStats.forEach { stat ->
                StatItem(
                    stat = stat,
                    modifier = Modifier
                        .weight(1F),
                )
            }
        }
    }
}

@Composable
private fun StatItem(
    stat: StatDisplayModel,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        val statText = if (currentWindowSizeClass().widthSizeClass == WindowWidthSizeClass.Expanded) {
            stat.fullName
        } else {
            stat.shortCode
        }

        Text(
            text = statText,
            style = MaterialTheme.typography.titleMedium,
        )

        Text(
            text = stat.value,
        )
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
    val imageSize = PWHLTheme.dimensions.imageSizeDefault

    val fontSize = with(LocalDensity.current) {
        imageSize.div(3).toSp()
    }

    val textStyle = MaterialTheme.typography.titleSmall.copy(
        fontSize = fontSize,
        lineHeight = fontSize.times(1.25),
    )

    Text(
        text = mvp.player.fullName,
        style = textStyle,
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
        val imageSize = PWHLTheme.dimensions.imageSizeDefault

        val fontSizeDp = imageSize.div(4)

        val fontSizeSp = with(LocalDensity.current) {
            fontSizeDp.toSp()
        }

        val textStyle = LocalTextStyle.current.copy(
            fontSize = fontSizeSp,
            lineHeight = fontSizeSp.times(1.25),
        )

        ImageWrapper(
            image = mvp.team.image,
            contentDescription = mvp.team.name,
            modifier = Modifier
                .size(fontSizeDp),
        )

        val subtitle = "#${mvp.player.jerseyNumber} • ${mvp.player.position}"

        Text(
            text = subtitle,
            style = textStyle,
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
            .size(PWHLTheme.dimensions.imageSizeDefault)
            .clip(CircleShape),
    )
}
