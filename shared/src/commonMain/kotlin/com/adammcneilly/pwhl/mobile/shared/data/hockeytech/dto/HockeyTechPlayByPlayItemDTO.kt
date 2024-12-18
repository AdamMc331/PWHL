package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechPlayByPlayItemDTO.Companion.FACE_OFF
import com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechPlayByPlayItemDTO.Companion.GOALIE_CHANGE
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable
data class HockeyTechPlayByPlayItemDTO<T : HockeyTechPlayByPlayItemDetailsDTO?>(
    val type: Byte,
    val data: T? = null,
) {
    companion object {
        const val GOALIE_CHANGE = "goalie_change"
        const val FACE_OFF = "faceoff"
    }
}

object HockeyTechPlayByPlayItemDTOSerializer : JsonContentPolymorphicSerializer<HockeyTechPlayByPlayItemDTO<*>>(
    HockeyTechPlayByPlayItemDTO::class,
) {
    override fun selectDeserializer(
        element: JsonElement,
    ): DeserializationStrategy<out HockeyTechPlayByPlayItemDTO<*>> {
        val event = element.jsonObject["event"]?.jsonPrimitive?.toString()

        println("Found Play By Play event: $event")

        return when (event) {
            GOALIE_CHANGE -> HockeyTechPlayByPlayItemDTO.serializer(HockeyTechGoalieChangeDetailsDTO.serializer())
            FACE_OFF -> HockeyTechPlayByPlayItemDTO.serializer(HockeyTechFaceOffDetailsDTO.serializer())
            else -> error("Unknown play by play event: $event")
        }
    }
}
