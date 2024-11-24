package com.pwhl.mobile.shared.displaymodels

/**
 * UI friendly information about a team and how they
 * preformed in an individual game.
 */
data class TeamGameResultDisplayModel(
    val team: TeamDisplayModel,
    val goals: Int,
)
