package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechPlayerSummaryDTO(
    @SerialName("birthDate")
    val birthDate: String? = null,
    @SerialName("firstName")
    val firstName: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("jerseyNumber")
    val jerseyNumber: Int? = null,
    @SerialName("lastName")
    val lastName: String? = null,
    @SerialName("playerImageURL")
    val playerImageURL: String? = null,
    @SerialName("position")
    val position: String? = null,
)
