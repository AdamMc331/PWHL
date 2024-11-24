package com.pwhl.mobile.shared.displaymodels

import com.pwhl.mobile.shared.models.Game
import kotlinx.datetime.Instant

data class GameDisplayModel(
    val id: String,
    val homeTeam: TeamDisplayModel,
    val awayTeam: TeamDisplayModel,
    val homeGoals: Int,
    val awayGoals: Int,
    val gameTime: Instant,
    val status: String,
) {
    constructor(game: Game) : this(
        id = game.id,
        homeTeam = TeamDisplayModel(game.homeTeam),
        awayTeam = TeamDisplayModel(game.awayTeam),
        homeGoals = game.homeGoals,
        awayGoals = game.awayGoals,
        gameTime = game.gameTime,
        status = game.status,
    )
}
