package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.PlayByPlayEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechShotEventDTO(
    @SerialName("details")
    val details: Details? = null,
    @SerialName("event")
    val event: String? = null,
) : HockeyTechPlayByPlayEventDTO {
    override fun toPlayByPlayEvent(): PlayByPlayEvent {
        return PlayByPlayEvent(
            eventType = event.orEmpty(),
        )
    }

    @Serializable
    data class Details(
        @SerialName("goalie")
        val goalie: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("isGoal")
        val isGoal: Boolean? = null,
        @SerialName("period")
        val period: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("shooter")
        val shooter: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("shooterTeamId")
        val shooterTeamId: String? = null,
        @SerialName("shotQuality")
        val shotQuality: String? = null,
        @SerialName("shotType")
        val shotType: String? = null,
        @SerialName("time")
        val time: String? = null,
        @SerialName("xLocation")
        val xLocation: Int? = null,
        @SerialName("yLocation")
        val yLocation: Int? = null,
    )
}
