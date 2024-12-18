package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.Period

data class PlayByPlayEventDisplayModel(
    val teamImage: ImageDisplayModel,
    val time: String,
    val title: String,
    val description: String,
    val period: Period,
    val highlightTeamId: String = "",
)
