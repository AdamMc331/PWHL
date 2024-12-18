package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGoalEventDTO(
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
        @SerialName("assistNumbers")
        val assistNumbers: List<String>? = null,
        @SerialName("assists")
        val assists: List<HockeyTechPlayerSummaryDTO>? = null,
        @SerialName("game_goal_id")
        val gameGoalId: String? = null,
        @SerialName("minus_players")
        val minusPlayers: List<HockeyTechPlayerSummaryDTO>? = null,
        @SerialName("period")
        val period: HockeyTechPeriodDTO? = null,
        @SerialName("plus_players")
        val plusPlayers: List<HockeyTechPlayerSummaryDTO>? = null,
        @SerialName("properties")
        val properties: HockeyTechGoalPropertiesDTO? = null,
        @SerialName("scoredBy")
        val scoredBy: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("scorerGoalNumber")
        val scorerGoalNumber: String? = null,
        @SerialName("team")
        val team: HockeyTechTeamInfoDTO? = null,
        @SerialName("time")
        val time: String? = null,
        @SerialName("xLocation")
        val xLocation: Int? = null,
        @SerialName("yLocation")
        val yLocation: Int? = null,
    )
}
