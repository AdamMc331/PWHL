package com.pwhl.mobile.shared.data.hockeytech.dto

import com.pwhl.mobile.shared.models.Team
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGameSummaryTeamDTO(
    @SerialName("info")
    val teamInfo: HockeyTechTeamInfoDTO? = null,
) {
    fun parseTeam(): Team {
        return Team(
            id = teamInfo?.id?.toString().orEmpty(),
            name = teamInfo?.name.orEmpty(),
            city = teamInfo?.city.orEmpty(),
            shortCode = teamInfo?.abbreviation.orEmpty(),
            imageUrl = teamInfo?.logo,
        )
    }
}
