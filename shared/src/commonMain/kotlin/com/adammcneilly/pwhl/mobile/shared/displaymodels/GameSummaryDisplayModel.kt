package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.GameSummary
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.DayOfWeekNames
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char

data class GameSummaryDisplayModel(
    val id: String,
    val homeTeam: TeamDisplayModel,
    val awayTeam: TeamDisplayModel,
    val status: String,
    val dateString: String,
) {
    constructor(game: GameSummary) : this(
        id = game.id,
        homeTeam = TeamDisplayModel(
            team = game.homeTeam,
        ),
        awayTeam = TeamDisplayModel(
            team = game.awayTeam,
        ),
        status = game.status,
        dateString = game.dateString(),
    )
}

private fun GameSummary.dateString(): String {
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
