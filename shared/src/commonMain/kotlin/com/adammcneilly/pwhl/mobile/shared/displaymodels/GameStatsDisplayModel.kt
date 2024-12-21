package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.GameTeamStats

data class GameStatsDisplayModel(
    val goals: Int,
    val hits: Int,
    val penaltyMinutes: Int,
    val powerPlayGoals: Int,
    val powerPlayOpportunities: Int,
    val shots: Int,
) {
    constructor(
        gameTeamStats: GameTeamStats,
        gameStarted: Boolean,
    ) : this(
        goals = gameTeamStats.goals,
        hits = gameTeamStats.hits,
        penaltyMinutes = gameTeamStats.penaltyMinutes,
        powerPlayGoals = gameTeamStats.powerPlayGoals,
        powerPlayOpportunities = gameTeamStats.powerPlayOpportunities,
        shots = gameTeamStats.shots,
    )
}
