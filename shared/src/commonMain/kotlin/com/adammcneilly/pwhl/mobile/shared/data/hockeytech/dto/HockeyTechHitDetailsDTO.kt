package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.PlayByPlayEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechHitDetailsDTO(
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
) : HockeyTechPlayByPlayEventDTO2 {
    override fun toPlayByPlayEvent(): PlayByPlayEvent {
        return PlayByPlayEvent(
            eventType = "hit",
        )
    }
}
