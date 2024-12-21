package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.GameDetail
import com.adammcneilly.pwhl.mobile.shared.ui.theme.PWHLColors
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.DayOfWeekNames
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char

data class GameDetailDisplayModel(
    val id: String,
    val homeTeam: TeamGameDetailResultDisplayModel,
    val awayTeam: TeamGameDetailResultDisplayModel,
    val mostValuablePlayers: List<MostValuablePlayerDisplayModel>,
    val status: String,
    val dateString: String,
) {
    constructor(game: GameDetail) : this(
        id = game.id,
        homeTeam = TeamGameDetailResultDisplayModel(
            teamGameResult = game.homeTeam,
            gameStarted = game.isStarted,
        ),
        awayTeam = TeamGameDetailResultDisplayModel(
            teamGameResult = game.awayTeam,
            gameStarted = game.isStarted,
        ),
        mostValuablePlayers = game.mostValuablePlayers.map(::MostValuablePlayerDisplayModel),
        status = game.status,
        dateString = game.dateString(),
    )

    fun getTeamStatComparisons(): List<StatComparisonDisplayModel> {
        val homeTeamColor = PWHLColors.fromTeamId(this.homeTeam.team.id)
        val awayTeamColor = PWHLColors.fromTeamId(this.awayTeam.team.id)

        return listOf(
            StatComparisonDisplayModel(
                statName = "Shots on Goal",
                leftValue = this.homeTeam.stats.shots,
                rightValue = this.awayTeam.stats.shots,
                leftColor = homeTeamColor,
                rightColor = awayTeamColor,
            ),
        )
    }
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
