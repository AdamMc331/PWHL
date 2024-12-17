package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechStandingsPropDTO(
    @SerialName("name")
    val name: HockeyTechTeamLinkDTO? = null,
    @SerialName("team_code")
    val teamCode: HockeyTechTeamLinkDTO? = null,
)
