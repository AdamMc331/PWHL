package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.GameDetailV2
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.DayOfWeekNames
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char

data class GameDetailDisplayModelV2(
    val id: String,
    val homeTeam: TeamGameResultDisplayModelV2,
    val awayTeam: TeamGameResultDisplayModelV2,
    val mostValuablePlayers: List<MostValuablePlayerDisplayModel>,
    val status: String,
    val dateString: String,
) {
    constructor(game: GameDetailV2) : this(
        id = game.id,
        homeTeam = TeamGameResultDisplayModelV2(
            teamGameResult = game.homeTeam,
            gameStarted = game.isStarted,
        ),
        awayTeam = TeamGameResultDisplayModelV2(
            teamGameResult = game.awayTeam,
            gameStarted = game.isStarted,
        ),
        mostValuablePlayers = game.mostValuablePlayers.map(::MostValuablePlayerDisplayModel),
        status = game.status,
        dateString = game.dateString(),
    )
}

private fun GameDetailV2.dateString(): String {
    val gameDateFormat = DateTimeComponents.Format {
        dayOfWeek(DayOfWeekNames.ENGLISH_ABBREVIATED)
        char(',')
        char(' ')
        monthName(MonthNames.ENGLISH_ABBREVIATED)
        char(' ')
        dayOfMonth(padding = Padding.NONE)
    }

    return this.time.format(gameDateFormat)
}
