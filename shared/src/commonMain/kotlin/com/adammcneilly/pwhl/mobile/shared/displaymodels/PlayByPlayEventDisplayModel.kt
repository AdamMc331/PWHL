package com.adammcneilly.pwhl.mobile.shared.displaymodels

data class PlayByPlayEventDisplayModel(
    val team: TeamDisplayModel,
    val time: String,
    val title: String,
    val description: String,
)
