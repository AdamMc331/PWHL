package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechPlayByPlayEventDTO.Companion.FACE_OFF
import com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechPlayByPlayEventDTO.Companion.GOALIE_CHANGE
import com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechPlayByPlayEventDTO.Companion.SHOT
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable
data class HockeyTechPlayByPlayEventDTO<T : HockeyTechPlayByPlayItemDetailsDTO?>(
    @SerialName("event")
    val event: String,
    val data: T? = null,
) {
    companion object {
        const val FACE_OFF = "faceoff"
        const val GOALIE_CHANGE = "goalie_change"
        const val SHOT = "shot"
    }
}

object HockeyTechPlayByPlayEventDTOSerializer : JsonContentPolymorphicSerializer<HockeyTechPlayByPlayEventDTO<*>>(
    HockeyTechPlayByPlayEventDTO::class,
) {
    override fun selectDeserializer(
        element: JsonElement,
    ): DeserializationStrategy<HockeyTechPlayByPlayEventDTO<*>> {
        val event = element.jsonObject["event"]?.jsonPrimitive?.toString()

        println("Found Play By Play event: $event")

        return when (event) {
            GOALIE_CHANGE -> HockeyTechPlayByPlayEventDTO.serializer(HockeyTechGoalieChangeDetailsDTO.serializer())
            FACE_OFF -> HockeyTechPlayByPlayEventDTO.serializer(HockeyTechFaceOffDetailsDTO.serializer())
            SHOT -> HockeyTechPlayByPlayEventDTO.serializer(HockeyTechPlayByPlayShotDetailsDTO.serializer())
            else -> error("Unknown play by play event: $event")
        }
    }
}
