package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechStandingsSectionDTO(
    @SerialName("data")
    val data: List<HockeyTechStandingsDataDTO?>? = null,
    @SerialName("title")
    val title: String? = null,
)
