package com.pwhl.mobile.shared.models

import kotlinx.datetime.Instant

data class GameDetail(
    val id: String,
    val homeTeam: TeamGameResult,
    val awayTeam: TeamGameResult,
    val time: Instant,
    val status: String,
    val isComplete: Boolean,
)
