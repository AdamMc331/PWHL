package com.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechTeamLinkDTO(
    @SerialName("teamLink")
    val teamLink: String? = null,
)
