package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.GameTeamStats
import com.adammcneilly.pwhl.mobile.shared.models.Team
import com.adammcneilly.pwhl.mobile.shared.models.TeamGameResultV2
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGameSummaryTeamDTO(
    @SerialName("info")
    val teamInfo: HockeyTechTeamInfoDTO? = null,
    @SerialName("stats")
    val stats: HockeyTechGameStatsDTO? = null,
) {
    private fun parseTeam(): Team {
        return Team(
            id = teamInfo?.id?.toString().orEmpty(),
            name = teamInfo?.name.orEmpty(),
            city = teamInfo?.city.orEmpty(),
            shortCode = teamInfo?.abbreviation.orEmpty(),
            imageUrl = teamInfo?.logo,
        )
    }

    private fun parseStats(): GameTeamStats {
        return GameTeamStats(
            assists = stats?.assistCount ?: 0,
            shots = stats?.shots ?: 0,
            goals = stats?.goals ?: 0,
            hits = stats?.hits ?: 0,
            powerPlayGoals = stats?.powerPlayGoals ?: 0,
            powerPlayOpportunities = stats?.powerPlayOpportunities ?: 0,
            penaltyMinutes = stats?.penaltyMinuteCount ?: 0,
            infractionCount = stats?.infractionCount ?: 0,
        )
    }

    fun parseTeamGameResult(): TeamGameResultV2 {
        return TeamGameResultV2(
            team = parseTeam(),
            stats = parseStats(),
        )
    }
}
