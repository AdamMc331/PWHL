package com.adammcneilly.pwhl.mobile.shared.displaymodels

import androidx.compose.ui.graphics.Color

data class StatComparisonDisplayModel(
    val stat: String,
    val homeTeamValue: String,
    val awayTeamValue: String,
    val homeTeamPercentage: Float,
    val homeTeamColor: Color,
    val awayTeamColor: Color,
)
