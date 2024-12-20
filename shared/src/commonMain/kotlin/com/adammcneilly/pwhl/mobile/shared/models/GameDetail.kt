package com.adammcneilly.pwhl.mobile.shared.models

import kotlinx.datetime.Instant

data class GameDetail(
    val id: String,
    val homeTeam: TeamGameDetailResult,
    val awayTeam: TeamGameDetailResult,
    val mostValuablePlayers: List<MostValuablePlayer>,
    val time: Instant,
    val status: String,
    val isStarted: Boolean,
    val isComplete: Boolean,
)
