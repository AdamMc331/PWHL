package com.adammcneilly.pwhl.mobile.shared.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.ui.theme.PWHLColors

private const val MAX_X = 600
private const val MAX_Y = 300

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
        val goalLinePercentage = (11F / 200F)
        val blueLinePercentage = (75F / 200F)

        val leftGoalLineOffset = goalLinePercentage * size.width
        val rightGoalLineOffset = (1 - goalLinePercentage) * size.width

        val leftBlueLineOffset = blueLinePercentage * size.width
        val rightBlueLineOffset = (1 - blueLinePercentage) * size.width

        drawRoundRect(
            color = Color.White,
            topLeft = Offset(0F, 0F),
            size = Size(size.width, size.height),
            style = Fill,
            cornerRadius = CornerRadius(leftGoalLineOffset),
        )

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

        drawLine(
            color = Color.Red,
            start = Offset(size.width / 2, 0F),
            end = Offset(size.width / 2, size.height),
            strokeWidth = 4.dp.toPx(),
        )

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

        drawCircle(
            color = Color.Blue,
            radius = ((size.width / 2) - leftBlueLineOffset) / 1.5F,
            center = Offset(
                x = size.width / 2,
                y = size.height / 2,
            ),
            style = Stroke(1.dp.toPx()),
        )

        val width = size.width
        val height = size.height

        events.forEach { event ->
            if (event.xLocation != null && event.yLocation != null) {
                val xPercentage = event.xLocation.toFloat() / MAX_X
                val yPercentage = event.yLocation.toFloat() / MAX_Y

                val x = xPercentage * width
                val y = yPercentage * height

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
    }
}
