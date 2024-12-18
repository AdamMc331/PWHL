package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGoalieChangeDetailsDTO(
    @SerialName("goalieComingIn")
    val goalieComingIn: HockeyTechPlayerSummaryDTO? = null,
    @SerialName("goalieGoingOut")
    val goalieGoingOut: HockeyTechPlayerSummaryDTO? = null,
    @SerialName("period")
    val period: HockeyTechPeriodDTO? = null,
    @SerialName("team_id")
    val teamId: String? = null,
    @SerialName("time")
    val time: String? = null,
)
