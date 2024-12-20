package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.TeamGameSummaryResult

/**
 * UI friendly information about a team and how they
 * preformed in an individual game.
 */
data class TeamGameSummaryResultDisplayModel(
    val team: TeamDisplayModel,
    val goals: Int,
    val isWinner: Boolean,
) {
    constructor(teamGameResult: TeamGameSummaryResult) : this(
        team = TeamDisplayModel(teamGameResult.team),
        goals = teamGameResult.goals,
        isWinner = teamGameResult.isWinner,
    )
}
