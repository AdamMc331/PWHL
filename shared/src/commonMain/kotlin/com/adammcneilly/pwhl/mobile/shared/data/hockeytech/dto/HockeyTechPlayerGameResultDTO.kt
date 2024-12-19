package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechPlayerGameResultDTO(
    @SerialName("info")
    val info: HockeyTechPlayerSummaryDTO? = null,
    @SerialName("starting")
    val starting: Int? = null,
    @SerialName("stats")
    val stats: HockeyTechGamePlayerStatsDTO? = null,
    @SerialName("status")
    val status: String? = null,
)
