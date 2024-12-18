package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.GameTeamStats

data class GameStatsDisplayModel(
    val goals: String,
) {
    constructor(
        gameTeamStats: GameTeamStats,
        gameStarted: Boolean,
    ) : this(
        goals = if (gameStarted) {
            gameTeamStats.goals.toString()
        } else {
            "–"
        },
    )
}
