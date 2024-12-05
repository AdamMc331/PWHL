package com.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechStandingsListResponseDTO(
    @SerialName("sections")
    val sections: List<HockeyTechStandingsSectionDTO?>? = null,
)
