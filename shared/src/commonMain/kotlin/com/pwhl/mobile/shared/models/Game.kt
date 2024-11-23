package com.pwhl.mobile.shared.models

import kotlinx.datetime.Instant

data class Game(
    val id: String,
    val homeTeam: Team,
    val awayTeam: Team,
    val homeGoals: Int,
    val awayGoals: Int,
    val gameTime: Instant,
)
