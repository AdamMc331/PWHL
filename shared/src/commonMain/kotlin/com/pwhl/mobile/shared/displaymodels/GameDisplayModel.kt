package com.pwhl.mobile.shared.displaymodels

import com.pwhl.mobile.shared.models.Game
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.DayOfWeekNames
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char

data class GameDisplayModel(
    val id: String,
    val homeTeam: TeamGameResultDisplayModel,
    val awayTeam: TeamGameResultDisplayModel,
    val status: String,
    val dateString: String,
) {
    constructor(game: Game) : this(
        id = game.id,
        homeTeam = TeamGameResultDisplayModel(
            teamGameResult = game.homeTeam,
        ),
        awayTeam = TeamGameResultDisplayModel(
            teamGameResult = game.awayTeam,
        ),
        status = game.status,
        dateString = game.dateString(),
    )
}

private fun Game.dateString(): String {
    val gameDateFormat = DateTimeComponents.Format {
        dayOfWeek(DayOfWeekNames.ENGLISH_ABBREVIATED)
        char(',')
        char(' ')
        monthName(MonthNames.ENGLISH_ABBREVIATED)
        dayOfMonth(padding = Padding.SPACE)
    }

    return this.time.format(gameDateFormat)
}
