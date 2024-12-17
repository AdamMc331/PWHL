package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.GameDetail
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
    constructor(game: GameDetail) : this(
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

private fun GameDetail.dateString(): String {
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
