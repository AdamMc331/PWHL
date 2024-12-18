package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.PlayByPlayEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechPlayByPlayEventDTO<T : HockeyTechPlayByPlayEventDTO2?>(
    @SerialName("event")
    val event: String,
    val data: T? = null,
) {
    fun toPlayByPlayEvent(): PlayByPlayEvent {
        return PlayByPlayEvent(
            eventType = event,
        )
    }

    companion object {
        const val FACE_OFF = "faceoff"
        const val GOALIE_CHANGE = "goalie_change"
        const val SHOT = "shot"
    }
}
