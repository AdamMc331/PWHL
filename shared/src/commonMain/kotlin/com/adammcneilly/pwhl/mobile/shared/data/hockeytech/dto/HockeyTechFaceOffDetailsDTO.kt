package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.PlayByPlayEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechFaceOffDetailsDTO(
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
) : HockeyTechPlayByPlayEventDTO2 {
    override fun toPlayByPlayEvent(): PlayByPlayEvent {
        return PlayByPlayEvent(
            eventType = "faceoff",
        )
    }
}
