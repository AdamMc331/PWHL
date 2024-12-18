package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.PlayerAndAssistCount
import com.adammcneilly.pwhl.mobile.shared.models.PlayerAndGoalCount
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayGoalEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGoalEventDTO(
    @SerialName("details")
    val details: Details? = null,
    @SerialName("event")
    val event: String? = null,
) : HockeyTechPlayByPlayEventDTO {
    override fun parsePlayByPlayEvent(): PlayByPlayEvent {
        require(details != null) {
            "Cannot parse goal event without details."
        }

        require(details.scoredBy != null) {
            "Cannot parse goal event without scorer."
        }

        require(details.period != null) {
            "Cannot parse goal event without period info."
        }

        require(details.team != null) {
            "Cannot parse goal event without team info."
        }

        return PlayByPlayGoalEvent(
            teamId = details.team.parseTeam().id,
            assistingPlayers = details.assists.orEmpty().mapIndexed { index, player ->
                val assistCount = details.assistNumbers?.get(index)?.toIntOrNull() ?: 0
                PlayerAndAssistCount(
                    player = player.parsePlayer(),
                    assistCount = assistCount,
                )
            },
            scoredBy = PlayerAndGoalCount(
                player = details.scoredBy.parsePlayer(),
                goalCount = details.scorerGoalNumber?.toIntOrNull() ?: 0,
            ),
            period = details.period.parsePeriod(),
            time = details.time.orEmpty(),
        )
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
