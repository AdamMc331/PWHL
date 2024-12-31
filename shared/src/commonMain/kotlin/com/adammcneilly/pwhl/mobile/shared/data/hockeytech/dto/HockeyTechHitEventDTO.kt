package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayHitEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechHitEventDTO(
    @SerialName("details")
    val details: Details? = null,
    @SerialName("event")
    val event: String? = null,
) : HockeyTechPlayByPlayEventDTO {
    override fun parsePlayByPlayEvent(): PlayByPlayEvent {
        require(details != null) {
            "Cannot parse hit event without details."
        }

        require(details.player != null) {
            "Cannot parse hit event without player."
        }

        require(details.period != null) {
            "Cannot parse hit event without period."
        }

        return PlayByPlayHitEvent(
            player = details.player.parsePlayer(),
            period = details.period.parsePeriod(),
            teamId = details.teamId.orEmpty(),
            time = details.time.orEmpty(),
            xLocation = details.xLocation,
            yLocation = details.yLocation,
        )
    }

    @Serializable
    data class Details(
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
    )
}
