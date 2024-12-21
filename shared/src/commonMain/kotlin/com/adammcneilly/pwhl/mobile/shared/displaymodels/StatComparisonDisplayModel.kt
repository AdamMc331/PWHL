package com.adammcneilly.pwhl.mobile.shared.displaymodels

import androidx.compose.ui.graphics.Color

data class StatComparisonDisplayModel(
    val statName: String,
    val leftValue: Float,
    val rightValue: Float,
    val leftColor: Color,
    val rightColor: Color,
) {
    constructor(
        statName: String,
        leftValue: Int,
        rightValue: Int,
        leftColor: Color,
        rightColor: Color,
    ) : this(
        statName = statName,
        leftValue = leftValue.toFloat(),
        rightValue = rightValue.toFloat(),
        leftColor = leftColor,
        rightColor = rightColor,
    )
}
