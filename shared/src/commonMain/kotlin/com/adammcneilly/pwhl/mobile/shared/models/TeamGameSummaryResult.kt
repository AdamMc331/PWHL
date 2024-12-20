package com.adammcneilly.pwhl.mobile.shared.models

data class TeamGameSummaryResult(
    val team: Team,
    val goals: Int,
    val isWinner: Boolean,
)
