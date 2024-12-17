package com.adammcneilly.pwhl.mobile.shared.models

data class TeamGameResult(
    val team: Team,
    val goals: Int,
    val isWinner: Boolean,
)
