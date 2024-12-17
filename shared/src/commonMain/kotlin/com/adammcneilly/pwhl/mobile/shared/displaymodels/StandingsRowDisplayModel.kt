package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.StandingsRow

data class StandingsRowDisplayModel(
    val rank: Int,
    val team: TeamDisplayModel,
    val gamesPlayed: Int,
    val gamesRemaining: Int,
    val points: Int,
    val regulationWins: Int,
    val regulationLosses: Int,
    val overtimeWins: Int,
    val overtimeLosses: Int,
    val winPercentage: Float,
    val goalsFor: Int,
    val goalsAgainst: Int,
) {
    constructor(standingsRow: StandingsRow) : this(
        rank = standingsRow.rank,
        team = TeamDisplayModel(standingsRow.team),
        gamesPlayed = standingsRow.gamesPlayed,
        gamesRemaining = standingsRow.gamesRemaining,
        points = standingsRow.points,
        regulationWins = standingsRow.regulationWins,
        regulationLosses = standingsRow.regulationLosses,
        overtimeWins = standingsRow.overtimeWins,
        overtimeLosses = standingsRow.overtimeLosses,
        winPercentage = standingsRow.winPercentage,
        goalsFor = standingsRow.goalsFor,
        goalsAgainst = standingsRow.goalsAgainst,
    )

    val record: String
        get() = "$regulationWins-$overtimeWins-$overtimeLosses-$regulationLosses"
}
