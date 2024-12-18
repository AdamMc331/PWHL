package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.PlayByPlayEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechHitEventDTO(
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
        @SerialName("period")
        val period: HockeyTechPeriodDTO? = null,
        @SerialName("player")
        val player: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("teamId")
        val teamId: String? = null,
        @SerialName("time")
        val time: String? = null,
        @SerialName("xLocation")
        val xLocation: Int? = null,
        @SerialName("yLocation")
        val yLocation: Int? = null,
    )
}
