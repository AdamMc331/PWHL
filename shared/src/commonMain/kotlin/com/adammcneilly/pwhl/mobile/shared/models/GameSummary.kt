package com.adammcneilly.pwhl.mobile.shared.models

import kotlinx.datetime.Instant

data class GameSummary(
    val id: String,
    val homeTeam: TeamGameResultV2,
    val awayTeam: TeamGameResultV2,
    val time: Instant,
    val status: String,
    val isStarted: Boolean,
    val isComplete: Boolean,
)
