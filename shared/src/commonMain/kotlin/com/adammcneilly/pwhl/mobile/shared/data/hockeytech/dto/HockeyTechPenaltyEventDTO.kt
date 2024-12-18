package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.PlayByPlayEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechPenaltyEventDTO(
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
        @SerialName("againstTeam")
        val againstTeam: HockeyTechTeamInfoDTO? = null,
        @SerialName("description")
        val description: String? = null,
        @SerialName("game_penalty_id")
        val gamePenaltyId: String? = null,
        @SerialName("isBench")
        val isBench: Boolean? = null,
        @SerialName("isPowerPlay")
        val isPowerPlay: Boolean? = null,
        @SerialName("minutes")
        val minutes: String? = null,
        @SerialName("period")
        val period: HockeyTechPeriodDTO? = null,
        @SerialName("ruleNumber")
        val ruleNumber: String? = null,
        @SerialName("servedBy")
        val servedBy: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("takenBy")
        val takenBy: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("time")
        val time: String? = null,
    )
}
