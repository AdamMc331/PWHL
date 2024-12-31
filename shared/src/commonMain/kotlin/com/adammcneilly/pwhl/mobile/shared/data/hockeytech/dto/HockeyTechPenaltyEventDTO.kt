package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayPenaltyEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechPenaltyEventDTO(
    @SerialName("details")
    val details: Details? = null,
    @SerialName("event")
    val event: String? = null,
) : HockeyTechPlayByPlayEventDTO {
    override fun parsePlayByPlayEvent(): PlayByPlayEvent {
        require(details != null) {
            "Cannot parse penalty event without details."
        }

        require(details.againstTeam != null) {
            "Cannot parse penalty event without team."
        }

        require(details.servedBy != null) {
            "Cannot parse penalty event without served by player."
        }

        require(details.period != null) {
            "Cannot parse penalty event without period info."
        }

        return PlayByPlayPenaltyEvent(
            againstTeamId = details.againstTeam.parseTeam().id,
            description = details.description.orEmpty(),
            minutes = details.minutes.orEmpty(),
            powerPlay = details.isPowerPlay == true,
            servedBy = details.servedBy.parsePlayer(),
            takenBy = details.takenBy?.parsePlayer(),
            period = details.period.parsePeriod(),
            time = details.time.orEmpty(),
            xLocation = null,
            yLocation = null,
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
