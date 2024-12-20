package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.TeamGameDetailResult

data class TeamGameDetailResultDisplayModel(
    val team: TeamDisplayModel,
    val stats: GameStatsDisplayModel,
) {
    constructor(
        teamGameResult: TeamGameDetailResult,
        gameStarted: Boolean,
    ) : this(
        team = TeamDisplayModel(teamGameResult.team),
        stats = GameStatsDisplayModel(teamGameResult.stats, gameStarted),
    )
}
