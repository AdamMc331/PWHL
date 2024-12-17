package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.StandingsRow
import com.adammcneilly.pwhl.mobile.shared.models.Team
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechStandingsDataDTO(
    @SerialName("prop")
    val prop: HockeyTechStandingsPropDTO? = null,
    @SerialName("row")
    val row: HockeyTechStandingsRowDTO? = null,
) {
    fun parseStandingsRow(): StandingsRow {
        return StandingsRow(
            rank = row?.rank ?: 0,
            team = parseTeam(),
            gamesPlayed = row?.gamesPlayed?.toIntOrNull() ?: 0,
            gamesRemaining = row?.gamesRemaining?.toIntOrNull() ?: 0,
            points = row?.points?.toIntOrNull() ?: 0,
            regulationWins = row?.regulationWins?.toIntOrNull() ?: 0,
            regulationLosses = row?.losses?.toIntOrNull() ?: 0,
            overtimeWins = row?.nonRegWins?.toIntOrNull() ?: 0,
            overtimeLosses = row?.nonRegLosses?.toIntOrNull() ?: 0,
            winPercentage = row?.percentage?.toFloatOrNull() ?: 0F,
            goalsFor = row?.goalsFor?.toIntOrNull() ?: 0,
            goalsAgainst = row?.goalsAgainst?.toIntOrNull() ?: 0,
        )
    }

    private fun parseTeam(): Team {
        val teamId = prop?.name?.teamLink.orEmpty()
        val teamCode = row?.teamCode.orEmpty()
        val teamName = row?.name.orEmpty()

        return Team(
            id = teamId,
            name = teamName,
            city = "",
            shortCode = teamCode,
            imageUrl = null,
        )
    }
}
