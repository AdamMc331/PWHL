package com.pwhl.mobile.shared.data.hockeytech.dto

import com.pwhl.mobile.shared.models.GameSummary
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGameSummaryDTO(
    @SerialName("details")
    val details: HockeyTechGameDetailsDTO? = null,
    @SerialName("homeTeam")
    val homeTeam: HockeyTechGameSummaryTeamDTO? = null,
    @SerialName("visitingTeam")
    val visitingTeam: HockeyTechGameSummaryTeamDTO? = null,
) {
    fun parseGameSummary(): GameSummary {
        val homeTeam = homeTeam?.parseTeam() ?: throw IllegalArgumentException("Cannot parse game without home team.")
        val visitingTeam = visitingTeam?.parseTeam() ?: throw IllegalArgumentException("Cannot parse game without visiting team.")

        return GameSummary(
            id = details?.id?.toString().orEmpty(),
            homeTeam = homeTeam,
            awayTeam = visitingTeam,
            time = Instant.parse(details?.gameDateISO8601.orEmpty()),
            status = details?.status.orEmpty(),
            isComplete = details?.status == "Final",
        )
    }
}
