@file:Suppress("DpUsageRule")

package com.adammcneilly.pwhl.mobile.shared.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.ui.theme.PWHLColors

private const val MAX_HOCKEYTECH_X = 600F
private const val MAX_HOCKEYTECH_Y = 300F

private const val NHL_RINK_WIDTH = 200F
private const val GOAL_LINE_DISTANCE_FROM_BOARDS = 11F
private const val BLUE_LINE_DISTANCE_FROM_BOARDS = 75F
private const val FACE_OFF_CIRCLE_RADIUS = 15F

private const val GOAL_LINE_PERCENTAGE = GOAL_LINE_DISTANCE_FROM_BOARDS / NHL_RINK_WIDTH
private const val BLUE_LINE_PERCENTAGE = BLUE_LINE_DISTANCE_FROM_BOARDS / NHL_RINK_WIDTH
private const val FACE_OFF_CIRCLE_PERCENTAGE = FACE_OFF_CIRCLE_RADIUS / NHL_RINK_WIDTH

@Composable
fun PlayByPlayMap(
    events: List<PlayByPlayEventDisplayModel>,
    modifier: Modifier = Modifier,
) {
    val dotRadius = with(LocalDensity.current) {
        3.dp.toPx()
    }

    Canvas(
        modifier = modifier,
    ) {
        drawRink()

        drawMidLine()

        drawBlueLines()

        drawGoalLines()

        events.forEach { event ->
            drawEventItem(event, dotRadius)
        }
    }
}

private fun DrawScope.drawEventItem(
    event: PlayByPlayEventDisplayModel,
    dotRadius: Float,
) {
    if (event.xLocation != null && event.yLocation != null) {
        val xPercentage = event.xLocation.toFloat() / MAX_HOCKEYTECH_X
        val yPercentage = event.yLocation.toFloat() / MAX_HOCKEYTECH_Y

        val x = xPercentage * size.width
        val y = yPercentage * size.height

        drawCircle(
            radius = dotRadius,
            color = PWHLColors.fromTeamId(event.teamId),
            center = Offset(
                x = x,
                y = y,
            ),
        )
    }
}

private fun DrawScope.drawBlueLines() {
    val leftBlueLineOffset = BLUE_LINE_PERCENTAGE * size.width
    val rightBlueLineOffset = size.width - leftBlueLineOffset

    drawLine(
        color = Color.Blue,
        start = Offset(leftBlueLineOffset, 0F),
        end = Offset(leftBlueLineOffset, size.height),
        strokeWidth = 4.dp.toPx(),
    )

    drawLine(
        color = Color.Blue,
        start = Offset(rightBlueLineOffset, 0F),
        end = Offset(rightBlueLineOffset, size.height),
        strokeWidth = 4.dp.toPx(),
    )
}

private fun DrawScope.drawMidLine() {
    val faceOffCircleRadius = FACE_OFF_CIRCLE_PERCENTAGE * size.width

    drawLine(
        color = Color.Red,
        start = Offset(size.width / 2, 0F),
        end = Offset(size.width / 2, size.height),
        strokeWidth = 4.dp.toPx(),
    )

    drawCircle(
        color = Color.Red,
        radius = faceOffCircleRadius,
        center = Offset(
            x = size.width / 2,
            y = size.height / 2,
        ),
        style = Stroke(1.dp.toPx()),
    )
}

private fun DrawScope.drawGoalLines() {
    val leftGoalLineOffset = GOAL_LINE_PERCENTAGE * size.width
    val rightGoalLineOffset = size.width - leftGoalLineOffset

    drawLine(
        color = Color.Red,
        start = Offset(leftGoalLineOffset, 0F),
        end = Offset(leftGoalLineOffset, size.height),
        strokeWidth = 2.dp.toPx(),
    )

    drawLine(
        color = Color.Red,
        start = Offset(rightGoalLineOffset, 0F),
        end = Offset(rightGoalLineOffset, size.height),
        strokeWidth = 2.dp.toPx(),
    )
}

private fun DrawScope.drawRink() {
    // This allows our corner radius to be from the back boards to the
    // start of the goal line. This isn't actually how a rink looks,
    // but it's good enough for prototyping.
    val goalLineOffset = GOAL_LINE_PERCENTAGE * size.width

    drawRoundRect(
        color = Color.White,
        topLeft = Offset(0F, 0F),
        size = Size(size.width, size.height),
        style = Fill,
        cornerRadius = CornerRadius(goalLineOffset),
    )
}
