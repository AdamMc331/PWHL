package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.GameStats

data class GameStatsDisplayModel(
    val goals: String,
) {
    constructor(
        gameStats: GameStats,
        gameStarted: Boolean,
    ) : this(
        goals = if (gameStarted) {
            gameStats.goals.toString()
        } else {
            "–"
        },
    )
}
