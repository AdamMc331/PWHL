package com.adammcneilly.pwhl.mobile.shared.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.displaymodels.StatComparisonDisplayModel

/**
 * For the stat line of the team leading in a given statistic, multiply the thickness
 * of that line by this scale, so it can be emphasized against the other team.
 */
private const val LEADING_TEAM_STAT_WIDTH_SCALE = 1.5F

/**
 * Unlike [AnimatableStatComparison], this is a stateless way to render
 * a [statComparison].
 *
 * If a caller doesn't care about animating a stat comparison, they can use this
 * composable directly and keep the default [percentageToRender] as 1.
 */
@Composable
fun StatComparison(
    statComparison: StatComparisonDisplayModel,
    modifier: Modifier = Modifier,
    percentageToRender: Float = 1F,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Text(
            text = statComparison.statName,
            style = MaterialTheme.typography.labelMedium,
        )

        StatComparisonRow(
            statComparison = statComparison,
            percentageToRender = percentageToRender,
        )
    }
}

@Composable
private fun StatComparisonRow(
    statComparison: StatComparisonDisplayModel,
    percentageToRender: Float,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = statComparison.leftValue.toString(),
            modifier = Modifier
                .padding(end = 16.dp),
        )

        StatComparisonLines(
            stat = statComparison,
            percentageToRender = percentageToRender,
            modifier = Modifier
                .weight(1F),
        )

        Text(
            text = statComparison.rightValue.toString(),
            modifier = Modifier
                .padding(start = 16.dp),
        )
    }
}

@Composable
private fun StatComparisonLines(
    stat: StatComparisonDisplayModel,
    percentageToRender: Float,
    modifier: Modifier = Modifier,
) {
    val dividerColor = LocalContentColor.current

    Canvas(
        modifier = modifier,
    ) {
        val midHeight = size.height.div(2)
        val totalValue = stat.leftValue.plus(stat.rightValue)
        val leftTeamPercentage = stat.leftValue.toFloat().div(totalValue)
        val dividingPoint = size.width.times(leftTeamPercentage)
        val lineWidth = 4.dp.toPx()
        val leadingLineWidth = lineWidth * LEADING_TEAM_STAT_WIDTH_SCALE

        val leftLineWidth = if (stat.leftValue > stat.rightValue) {
            leadingLineWidth
        } else {
            lineWidth
        }

        val rightLineWidth = if (stat.rightValue > stat.leftValue) {
            leadingLineWidth
        } else {
            lineWidth
        }

        drawLeftLine(
            midHeight = midHeight,
            dividingPoint = dividingPoint,
            lineWidth = leftLineWidth,
            animationPercentage = percentageToRender,
            color = stat.leftColor,
        )
        drawRightLine(
            dividingPoint = dividingPoint,
            midHeight = midHeight,
            lineWidth = rightLineWidth,
            animationPercentage = percentageToRender,
            color = stat.rightColor,
        )
        drawDivider(
            dividingPoint = dividingPoint,
            midHeight = midHeight,
            lineWidth = lineWidth,
            dividerColor = dividerColor,
            animationPercentage = percentageToRender,
        )
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

private fun DrawScope.drawRightLine(
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

private fun DrawScope.drawLeftLine(
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
