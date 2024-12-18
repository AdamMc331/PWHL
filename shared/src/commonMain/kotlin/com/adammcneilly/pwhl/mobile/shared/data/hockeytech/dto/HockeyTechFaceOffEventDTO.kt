package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayFaceOffEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechFaceOffEventDTO(
    @SerialName("details")
    val details: Details? = null,
    @SerialName("event")
    val event: String? = null,
) : HockeyTechPlayByPlayEventDTO {
    override fun toPlayByPlayEvent(): PlayByPlayEvent {
        require(details != null) {
            "Cannot parse faceoff event without details."
        }

        require(details.homePlayer != null) {
            "Cannot parse faceoff event without home player."
        }

        require(details.visitingPlayer != null) {
            "Cannot parse faceoff event without visiting player."
        }

        require(details.period != null) {
            "Cannot parse faceoff event without period info."
        }

        return PlayByPlayFaceOffEvent(
            homePlayer = details.homePlayer.parsePlayer(),
            awayPlayer = details.visitingPlayer.parsePlayer(),
            homeWin = details.homeWin == "1",
            period = details.period.parsePeriod(),
            time = details.time.orEmpty(),
        )
    }

    @Serializable
    data class Details(
        @SerialName("homePlayer")
        val homePlayer: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("homeWin")
        val homeWin: String? = null,
        @SerialName("period")
        val period: HockeyTechPeriodDTO? = null,
        @SerialName("time")
        val time: String? = null,
        @SerialName("visitingPlayer")
        val visitingPlayer: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("xLocation")
        val xLocation: Int? = null,
        @SerialName("yLocation")
        val yLocation: Int? = null,
    )
}
