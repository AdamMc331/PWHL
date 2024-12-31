package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayShotEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechShotEventDTO(
    @SerialName("details")
    val details: Details? = null,
    @SerialName("event")
    val event: String? = null,
) : HockeyTechPlayByPlayEventDTO {
    override fun parsePlayByPlayEvent(): PlayByPlayEvent {
        require(details != null) {
            "Cannot parse shot event without details."
        }
        require(details.goalie != null) {
            "Cannot parse shot event without goalie."
        }

        require(details.shooter != null) {
            "Cannot parse shot event without shooter."
        }

        require(details.period != null) {
            "Cannot parse shot event without period info."
        }

        return PlayByPlayShotEvent(
            goalie = details.goalie.parsePlayer(),
            shooter = details.shooter.parsePlayer(),
            shooterTeamId = details.shooterTeamId.orEmpty(),
            isGoal = details.isGoal == true,
            period = details.period.parsePeriod(),
            time = details.time.orEmpty(),
            xLocation = details.xLocation,
            yLocation = details.yLocation,
        )
    }

    @Serializable
    data class Details(
        @SerialName("goalie")
        val goalie: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("isGoal")
        val isGoal: Boolean? = null,
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
