package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayBlockedShotEvent
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechBlockedShotEventDTO(
    @SerialName("details")
    val details: Details? = null,
    @SerialName("event")
    val event: String? = null,
) : HockeyTechPlayByPlayEventDTO {
    override fun parsePlayByPlayEvent(): PlayByPlayEvent {
        require(details != null) {
            "Cannot parse blocked shot event without details."
        }

        require(details.period != null) {
            "Cannot parse blocked shot event without period info."
        }

        require(details.shooter != null) {
            "Cannot parse blocked shot event without shooter info."
        }

        require(details.blocker != null) {
            "Cannot parse blocked shot event without blocker info."
        }

        return PlayByPlayBlockedShotEvent(
            blocker = details.blocker.parsePlayer(),
            goalie = details.goalie?.parsePlayer(),
            shooter = details.shooter.parsePlayer(),
            period = details.period.parsePeriod(),
            shooterTeamId = details.shooterTeamId.orEmpty(),
            time = details.time.orEmpty(),
        )
    }

    @Serializable
    data class Details(
        @SerialName("blocker")
        val blocker: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("goalie")
        val goalie: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("period")
        val period: HockeyTechPeriodDTO? = null,
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
