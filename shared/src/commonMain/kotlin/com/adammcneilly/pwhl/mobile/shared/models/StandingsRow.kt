package com.adammcneilly.pwhl.mobile.shared.models

data class StandingsRow(
    val rank: Int,
    val team: Team,
    val gamesPlayed: Int,
    val gamesRemaining: Int,
    val points: Int,
    val regulationWins: Int,
    val regulationLosses: Int,
    val overtimeWins: Int,
    val overtimeLosses: Int,
    val winPercentage: Float,
    val goalsFor: Int,
    val goalsAgainst: Int,
)
