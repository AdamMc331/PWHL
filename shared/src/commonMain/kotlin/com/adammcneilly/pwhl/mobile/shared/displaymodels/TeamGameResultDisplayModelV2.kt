package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.TeamGameResultV2

data class TeamGameResultDisplayModelV2(
    val team: TeamDisplayModel,
    val stats: GameStatsDisplayModel,
) {
    constructor(
        teamGameResult: TeamGameResultV2,
        gameStarted: Boolean,
    ) : this(
        team = TeamDisplayModel(teamGameResult.team),
        stats = GameStatsDisplayModel(teamGameResult.stats, gameStarted),
    )
}
