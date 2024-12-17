package com.adammcneilly.pwhl.mobile.shared.models

data class GameStats(
    val assists: Int,
    val goals: Int,
    val hits: Int,
    val infractionCount: Int,
    val penaltyMinutes: Int,
    val powerPlayGoals: Int,
    val powerPlayOpportunities: Int,
    val shots: Int,
)
