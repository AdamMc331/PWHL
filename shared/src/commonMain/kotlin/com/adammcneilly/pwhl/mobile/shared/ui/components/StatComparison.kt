package com.adammcneilly.pwhl.mobile.shared.ui.components

import androidx.compose.animation.core.AnimationState
import androidx.compose.animation.core.animateTo
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.ui.modifiers.whenInView
import kotlinx.coroutines.launch

/**
 * For the stat line of the team leading in a given statistic, multiply the thickness
 * of that line by this scale, so it can be emphasized against the other team.
 */
private const val LEADING_TEAM_STAT_WIDTH_SCALE = 1.5F

/**
 * Shows the comparison between [homeTeamValue] and [awayTeamValue] by drawing lines on a canvas.
 *
 * Still to do: Don't provide integers here.
 * Ideally we make a `StatComparisonDisplayModel` that has the text UI value, plus the percentage of total between teams
 * and the color of the line.
 */
@Composable
fun AnimatableStatComparison(
    homeTeamValue: Int,
    awayTeamValue: Int,
    homeTeamColor: Color,
    awayTeamColor: Color,
    modifier: Modifier = Modifier,
    initialAnimationPercentage: Float = 0F,
    showValues: Boolean = false,
) {
    val animationPercentage = remember {
        AnimationState(initialAnimationPercentage)
    }

    val coroutineScope = rememberCoroutineScope()

    StatComparison(
        homeTeamValue = homeTeamValue,
        awayTeamValue = awayTeamValue,
        homeTeamColor = homeTeamColor,
        awayTeamColor = awayTeamColor,
        percentageToRender = animationPercentage.value,
        showValues = showValues,
        modifier = modifier
            .whenInView {
                coroutineScope.launch {
                    animationPercentage.animateTo(
                        targetValue = 1F,
                        animationSpec = tween(
                            durationMillis = 1000,
                        ),
                    )
                }
            },
    )
}

/**
 * Unlike [AnimatableStatComparison], this is a stateless way to render
 * a comparison between a [homeTeamValue] and [awayTeamValue].
 *
 * If a caller doesn't care about animating a stat comparison, they can use this
 * composable directly and keep the default [percentageToRender] as 1.
 */
@Composable
fun StatComparison(
    homeTeamValue: Int,
    awayTeamValue: Int,
    homeTeamColor: Color,
    awayTeamColor: Color,
    modifier: Modifier = Modifier,
    percentageToRender: Float = 1F,
    showValues: Boolean = false,
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = homeTeamValue.toString(),
            )

            Text(
                text = "Goals",
            )

            Text(
                text = awayTeamValue.toString(),
            )
        }

        StatComparisonLines(
            homeTeamValue = homeTeamValue,
            awayTeamValue = awayTeamValue,
            homeTeamColor = homeTeamColor,
            awayTeamColor = awayTeamColor,
            animationPercentage = percentageToRender,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
        )
    }
}

@Composable
private fun StatComparisonLines(
    homeTeamValue: Int,
    awayTeamValue: Int,
    homeTeamColor: Color,
    awayTeamColor: Color,
    animationPercentage: Float,
    modifier: Modifier = Modifier,
) {
    val dividerColor = LocalContentColor.current

    Canvas(
        modifier = modifier,
    ) {
        val yOffset = size.height.div(2)
        val totalValue = homeTeamValue.plus(awayTeamValue)
        val homeTeamPercentage = homeTeamValue.toFloat().div(totalValue)
        val dividingPoint = size.width.times(homeTeamPercentage)
        val lineWidth = 6.dp.toPx()
        val leadingLineWidth = lineWidth * LEADING_TEAM_STAT_WIDTH_SCALE

        val homeTeamLineWidth = if (homeTeamValue > awayTeamValue) {
            leadingLineWidth
        } else {
            lineWidth
        }

        val awayTeamLineWidth = if (awayTeamValue > homeTeamValue) {
            leadingLineWidth
        } else {
            lineWidth
        }

        drawHomeTeamLine(
            yOffset = yOffset,
            endXOffset = dividingPoint,
            lineWidth = homeTeamLineWidth,
            animationPercentage = animationPercentage,
            color = homeTeamColor,
        )
        drawAwayTeamLine(
            startXOffset = dividingPoint,
            yOffset = yOffset,
            lineWidth = awayTeamLineWidth,
            animationPercentage = animationPercentage,
            color = awayTeamColor,
        )
        drawDivider(
            xOffset = dividingPoint,
            yOffset = yOffset,
            lineWidth = lineWidth,
            dividerColor = dividerColor,
            animationPercentage = animationPercentage,
        )
    }
}

private fun DrawScope.drawDivider(
    xOffset: Float,
    yOffset: Float,
    lineWidth: Float,
    dividerColor: Color,
    animationPercentage: Float,
) {
    val totalDividerOffset = lineWidth.times(2)
    val dividerOffset = totalDividerOffset * animationPercentage

    drawLine(
        color = dividerColor,
        start = Offset(
            x = xOffset,
            y = yOffset.minus(dividerOffset),
        ),
        end = Offset(
            x = xOffset,
            y = yOffset.plus(dividerOffset),
        ),
        strokeWidth = lineWidth,
    )
}

/**
 * Draw a filled line with the supplied [color] that represents the portion of this statistic
 * earned by the away team.
 *
 * @param[startXOffset] The value in pixels that defines where the start of the away team stat line is.
 */
private fun DrawScope.drawAwayTeamLine(
    startXOffset: Float,
    yOffset: Float,
    lineWidth: Float,
    animationPercentage: Float,
    color: Color,
) {
    val totalLength = (size.width - startXOffset)
    val lengthToRender = totalLength * animationPercentage
    val endingX = startXOffset + lengthToRender

    drawLine(
        color = color,
        start = Offset(
            x = startXOffset,
            y = yOffset,
        ),
        end = Offset(
            x = endingX,
            y = yOffset,
        ),
        strokeWidth = lineWidth,
    )
}

/**
 * Draw a filled line with the supplied [color] that represents the portion of this statistic
 * earned by the home team.
 *
 * @param[endXOffset] The value in pixels that defines where the end of the home team stat line is.
 */
private fun DrawScope.drawHomeTeamLine(
    yOffset: Float,
    endXOffset: Float,
    lineWidth: Float,
    animationPercentage: Float,
    color: Color,
) {
    val lineLengthToRender = animationPercentage * endXOffset
    val startingX = (endXOffset - lineLengthToRender)

    drawLine(
        color = color,
        start = Offset(
            x = startingX,
            y = yOffset,
        ),
        end = Offset(
            x = endXOffset,
            y = yOffset,
        ),
        strokeWidth = lineWidth,
    )
}
