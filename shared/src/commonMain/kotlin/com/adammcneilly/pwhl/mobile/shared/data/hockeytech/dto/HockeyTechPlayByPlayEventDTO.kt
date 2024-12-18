package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable(
    with = HockeyTechPlayByPlayEventDTOSerializer::class,
)
sealed interface HockeyTechPlayByPlayEventDTO {
    fun parsePlayByPlayEvent(): PlayByPlayEvent
}

object HockeyTechPlayByPlayEventDTOSerializer : JsonContentPolymorphicSerializer<HockeyTechPlayByPlayEventDTO>(
    HockeyTechPlayByPlayEventDTO::class,
) {
    private const val BLOCKED_SHOT = "blocked_shot"
    private const val FACE_OFF = "faceoff"
    private const val GOAL = "goal"
    private const val GOALIE_CHANGE = "goalie_change"
    private const val HIT = "hit"
    private const val PENALTY = "penalty"
    private const val SHOOTOUT = "shootout"
    private const val SHOT = "shot"

    override fun selectDeserializer(
        element: JsonElement,
    ): DeserializationStrategy<HockeyTechPlayByPlayEventDTO> {
        val event = element.jsonObject["event"]?.jsonPrimitive?.toString()?.replace("\"", "")

        return when (event) {
            BLOCKED_SHOT -> HockeyTechBlockedShotEventDTO.serializer()
            FACE_OFF -> HockeyTechFaceOffEventDTO.serializer()
            GOAL -> HockeyTechGoalEventDTO.serializer()
            GOALIE_CHANGE -> HockeyTechGoalieChangeEventDTO.serializer()
            HIT -> HockeyTechHitEventDTO.serializer()
            PENALTY -> HockeyTechPenaltyEventDTO.serializer()
            SHOOTOUT -> HockeyTechShootOutEventDTO.serializer()
            SHOT -> HockeyTechShotEventDTO.serializer()
            else -> error("Unknown play by play event: $event")
        }
    }
}
