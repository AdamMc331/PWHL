package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGameStatsDTO(
    @SerialName("assistCount")
    val assistCount: Int? = null,
    @SerialName("goalCount")
    val goalCount: Int? = null,
    @SerialName("goals")
    val goals: Int? = null,
    @SerialName("hits")
    val hits: Int? = null,
    @SerialName("infractionCount")
    val infractionCount: Int? = null,
    @SerialName("penaltyMinuteCount")
    val penaltyMinuteCount: Int? = null,
    @SerialName("powerPlayGoals")
    val powerPlayGoals: Int? = null,
    @SerialName("powerPlayOpportunities")
    val powerPlayOpportunities: Int? = null,
    @SerialName("shots")
    val shots: Int? = null,
)
