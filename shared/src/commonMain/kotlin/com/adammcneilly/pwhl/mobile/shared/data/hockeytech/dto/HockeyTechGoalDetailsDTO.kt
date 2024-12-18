package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.PlayByPlayEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGoalDetailsDTO(
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
) : HockeyTechPlayByPlayEventDTO2 {
    override fun toPlayByPlayEvent(): PlayByPlayEvent {
        return PlayByPlayEvent(
            eventType = "goal",
        )
    }
}
