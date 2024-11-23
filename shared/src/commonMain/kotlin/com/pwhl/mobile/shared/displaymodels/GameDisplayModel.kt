package com.pwhl.mobile.shared.displaymodels

import kotlinx.datetime.Instant

data class GameDisplayModel(
    val id: String,
    val homeTeam: TeamDisplayModel,
    val awayTeam: TeamDisplayModel,
    val homeGoals: Int,
    val awayGoals: Int,
    val gameTime: Instant,
)
