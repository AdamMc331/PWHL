package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechStandingsSectionListDTO(
    @SerialName("sections")
    val sections: List<HockeyTechStandingsSectionDTO?>? = null,
)
