package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechPeriodDTO(
    @SerialName("id")
    val id: String? = null,
    @SerialName("longName")
    val longName: String? = null,
    @SerialName("shortName")
    val shortName: String? = null,
)
