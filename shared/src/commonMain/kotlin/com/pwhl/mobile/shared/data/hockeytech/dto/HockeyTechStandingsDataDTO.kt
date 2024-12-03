package com.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechStandingsDataDTO(
    @SerialName("prop")
    val prop: HockeyTechStandingsPropDTO? = null,
    @SerialName("row")
    val row: HockeyTechStandingsRowDTO? = null,
)
