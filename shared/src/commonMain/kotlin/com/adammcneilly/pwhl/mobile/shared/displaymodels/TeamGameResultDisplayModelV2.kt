package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.GameStats
import com.adammcneilly.pwhl.mobile.shared.models.TeamGameResultV2

data class TeamGameResultDisplayModelV2(
    val team: TeamDisplayModel,
    val stats: GameStats,
) {
    constructor(teamGameResult: TeamGameResultV2) : this(
        team = TeamDisplayModel(teamGameResult.team),
        stats = teamGameResult.stats,
    )
}
