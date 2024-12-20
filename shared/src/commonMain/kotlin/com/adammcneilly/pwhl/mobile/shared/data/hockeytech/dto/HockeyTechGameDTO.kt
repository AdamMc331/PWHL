package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.GameDetailV2
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGameDTO(
    @SerialName("details")
    val details: HockeyTechGameDetailsDTO? = null,
    @SerialName("homeTeam")
    val homeTeam: HockeyTechGameDetailTeamDTO? = null,
    @SerialName("visitingTeam")
    val visitingTeam: HockeyTechGameDetailTeamDTO? = null,
    @SerialName("mostValuablePlayers")
    val mostValuablePlayers: List<HockeyTechMVPDTO>? = null,
) {
    fun parseGameDetail(): GameDetailV2 {
        require(homeTeam != null) {
            "Cannot parse game summary without home team."
        }

        require(visitingTeam != null) {
            "Cannot parse game summary without visiting team."
        }

        return GameDetailV2(
            id = details?.id?.toString().orEmpty(),
            homeTeam = homeTeam.parseTeamGameResult(),
            awayTeam = visitingTeam.parseTeamGameResult(),
            time = Instant.parse(details?.gameDateISO8601.orEmpty()),
            mostValuablePlayers = mostValuablePlayers?.map(HockeyTechMVPDTO::parseMostValuablePlayer).orEmpty(),
            status = details?.status.orEmpty(),
            isComplete = details?.final == "1",
            isStarted = details?.started == "1",
        )
    }
}
