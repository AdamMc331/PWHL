package com.pwhl.mobile.shared.displaymodels

import com.pwhl.mobile.shared.models.Game

data class GameDisplayModel(
    val id: String,
    val homeTeam: TeamGameResultDisplayModel,
    val awayTeam: TeamGameResultDisplayModel,
    val status: String,
) {
    constructor(game: Game) : this(
        id = game.id,
        homeTeam = TeamGameResultDisplayModel(
            team = TeamDisplayModel(game.homeTeam),
            goals = game.homeGoals,
        ),
        awayTeam = TeamGameResultDisplayModel(
            team = TeamDisplayModel(game.awayTeam),
            goals = game.awayGoals,
        ),
        status = game.status,
    )
}
