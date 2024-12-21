package com.adammcneilly.pwhl.mobile.shared.displaymodels

import androidx.compose.ui.graphics.Color

data class StatComparisonDisplayModel(
    val statName: String,
    val leftValue: Int,
    val rightValue: Int,
    val leftColor: Color,
    val rightColor: Color,
)
