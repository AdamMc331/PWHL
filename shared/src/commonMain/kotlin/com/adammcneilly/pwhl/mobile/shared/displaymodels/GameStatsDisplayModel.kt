package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.GameTeamStats

data class GameStatsDisplayModel(
    val goals: Int,
    val shots: Int,
) {
    constructor(
        gameTeamStats: GameTeamStats,
        gameStarted: Boolean,
    ) : this(
        goals = gameTeamStats.goals,
        shots = gameTeamStats.shots,
    )
}
