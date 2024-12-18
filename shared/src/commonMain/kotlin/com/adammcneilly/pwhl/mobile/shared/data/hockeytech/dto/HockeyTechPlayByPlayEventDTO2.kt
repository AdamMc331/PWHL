package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechPlayByPlayEventDTO.Companion.FACE_OFF
import com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechPlayByPlayEventDTO.Companion.GOALIE_CHANGE
import com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechPlayByPlayEventDTO.Companion.SHOT
import com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechPlayByPlayEventDTO2.Companion.BLOCKED_SHOT
import com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechPlayByPlayEventDTO2.Companion.HIT
import com.adammcneilly.pwhl.mobile.shared.models.PlayByPlayEvent
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable(
    with = HockeyTechPlayByPlayEventDTOSerializer::class,
)
sealed interface HockeyTechPlayByPlayEventDTO2 {
    fun toPlayByPlayEvent(): PlayByPlayEvent

    companion object {
        const val BLOCKED_SHOT = "blocked_shot"
        const val FACE_OFF = "faceoff"
        const val GOALIE_CHANGE = "goalie_change"
        const val HIT = "hit"
        const val SHOT = "shot"
    }
}

object HockeyTechPlayByPlayEventDTOSerializer : JsonContentPolymorphicSerializer<HockeyTechPlayByPlayEventDTO2>(
    HockeyTechPlayByPlayEventDTO2::class,
) {
    override fun selectDeserializer(
        element: JsonElement,
    ): DeserializationStrategy<HockeyTechPlayByPlayEventDTO2> {
        val event = element.jsonObject["event"]?.jsonPrimitive?.toString()?.replace("\"", "")

        println("Found Play By Play event: $event")

        return when (event) {
            BLOCKED_SHOT -> HockeyTechBlockedShotDetailsDTO.serializer()
            GOALIE_CHANGE -> HockeyTechGoalieChangeDetailsDTO.serializer()
            FACE_OFF -> HockeyTechFaceOffDetailsDTO.serializer()
            HIT -> HockeyTechHitDetailsDTO.serializer()
            SHOT -> HockeyTechPlayByPlayShotDetailsDTO.serializer()
            else -> error("Unknown play by play event: $event")
        }
    }
}
