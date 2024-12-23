package com.adammcneilly.pwhl.mobile.shared.ui.components

import androidx.compose.animation.core.AnimationState
import androidx.compose.animation.core.animateTo
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LocalContentColor
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
    Row(
        modifier = modifier
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        StatComparisonLines(
            homeTeamValue = homeTeamValue,
            awayTeamValue = awayTeamValue,
            homeTeamColor = homeTeamColor,
            awayTeamColor = awayTeamColor,
            percentageToRender = percentageToRender,
            modifier = Modifier
                .weight(1F),
        )
    }
}

@Composable
private fun StatComparisonLines(
    homeTeamValue: Int,
    awayTeamValue: Int,
    percentageToRender: Float,
    homeTeamColor: Color,
    awayTeamColor: Color,
    modifier: Modifier = Modifier,
) {
    val dividerColor = LocalContentColor.current

    Canvas(
        modifier = modifier,
    ) {
        val midHeight = size.height.div(2)
        val totalValue = homeTeamValue.plus(awayTeamValue)
        val blueTeamPercentage = homeTeamValue.toFloat().div(totalValue)
        val dividingPoint = size.width.times(blueTeamPercentage)
        val lineWidth = 4.dp.toPx()
        val leadingLineWidth = lineWidth * LEADING_TEAM_STAT_WIDTH_SCALE

        val blueLineWidth = if (homeTeamValue > awayTeamValue) {
            leadingLineWidth
        } else {
            lineWidth
        }

        val orangeLineWidth = if (awayTeamValue > homeTeamValue) {
            leadingLineWidth
        } else {
            lineWidth
        }

        drawHomeTeamLine(midHeight, dividingPoint, blueLineWidth, percentageToRender, homeTeamColor)
        drawAwayTeamLine(dividingPoint, midHeight, orangeLineWidth, percentageToRender, awayTeamColor)
        drawDivider(dividingPoint, midHeight, lineWidth, dividerColor, percentageToRender)
    }
}

private fun DrawScope.drawDivider(
    dividingPoint: Float,
    midHeight: Float,
    lineWidth: Float,
    dividerColor: Color,
    animationPercentage: Float,
) {
    val totalDividerOffset = lineWidth.times(2)
    val dividerOffset = totalDividerOffset * animationPercentage

    drawLine(
        color = dividerColor,
        start = Offset(
            x = dividingPoint,
            y = midHeight.minus(dividerOffset),
        ),
        end = Offset(
            x = dividingPoint,
            y = midHeight.plus(dividerOffset),
        ),
        strokeWidth = lineWidth,
    )
}

private fun DrawScope.drawAwayTeamLine(
    dividingPoint: Float,
    midHeight: Float,
    lineWidth: Float,
    animationPercentage: Float,
    color: Color,
) {
    val totalLength = (size.width - dividingPoint)
    val lengthToRender = totalLength * animationPercentage
    val endingX = dividingPoint + lengthToRender

    drawLine(
        color = color,
        start = Offset(
            x = dividingPoint,
            y = midHeight,
        ),
        end = Offset(
            x = endingX,
            y = midHeight,
        ),
        strokeWidth = lineWidth,
    )
}

private fun DrawScope.drawHomeTeamLine(
    midHeight: Float,
    dividingPoint: Float,
    lineWidth: Float,
    animationPercentage: Float,
    color: Color,
) {
    val lineLengthToRender = animationPercentage * dividingPoint
    val startingX = (dividingPoint - lineLengthToRender)

    drawLine(
        color = color,
        start = Offset(
            x = startingX,
            y = midHeight,
        ),
        end = Offset(
            x = dividingPoint,
            y = midHeight,
        ),
        strokeWidth = lineWidth,
    )
}
