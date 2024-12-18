package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.PlayByPlayEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechPlayByPlayShotDetailsDTO(
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
) : HockeyTechPlayByPlayEventDTO2 {
    override fun toPlayByPlayEvent(): PlayByPlayEvent {
        return PlayByPlayEvent(
            eventType = "shot",
        )
    }
}
