package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayGoalieChangeEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGoalieChangeEventDTO(
    @SerialName("details")
    val details: Details? = null,
    @SerialName("event")
    val event: String? = null,
) : HockeyTechPlayByPlayEventDTO {
    override fun parsePlayByPlayEvent(): PlayByPlayEvent {
        require(details != null) {
            "Cannot parse goalie change event without details."
        }

        require(details.period != null) {
            "Cannot parse goalie change event without period info."
        }

        return PlayByPlayGoalieChangeEvent(
            goalieComingIn = details.goalieComingIn?.parsePlayer(),
            goalieComingOut = details.goalieGoingOut?.parsePlayer(),
            teamId = details.teamId.orEmpty(),
            period = details.period.parsePeriod(),
            time = details.time.orEmpty(),
            xLocation = null,
            yLocation = null,
        )
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
