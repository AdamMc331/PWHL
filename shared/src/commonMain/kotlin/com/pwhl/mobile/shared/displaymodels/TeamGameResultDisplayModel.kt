package com.pwhl.mobile.shared.displaymodels

import com.pwhl.mobile.shared.models.TeamGameResult

/**
 * UI friendly information about a team and how they
 * preformed in an individual game.
 */
data class TeamGameResultDisplayModel(
    val team: TeamDisplayModel,
    val goals: Int,
    val isWinner: Boolean,
) {
    constructor(teamGameResult: TeamGameResult) : this(
        team = TeamDisplayModel(teamGameResult.team),
        goals = teamGameResult.goals,
        isWinner = teamGameResult.isWinner,
    )
}
