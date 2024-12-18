package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGoalieChangeEventDTO(
    @SerialName("details")
    val details: Details? = null,
    @SerialName("event")
    val event: String? = null,
) : HockeyTechPlayByPlayEventDTO {
    override fun toPlayByPlayEvent(): PlayByPlayEvent {
        TODO("Not Yet Implemented")
    }

    @Serializable
    data class Details(
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
}
