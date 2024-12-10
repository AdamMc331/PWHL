package com.pwhl.mobile.shared.models

import kotlinx.datetime.Instant

data class GameSummary(
    val id: String,
    val homeTeam: Team,
    val awayTeam: Team,
    val time: Instant,
    val status: String,
    val isComplete: Boolean,
)
