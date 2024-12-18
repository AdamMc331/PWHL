package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.Period
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
) {
    fun parsePeriod(): Period {
        return Period(
            id = id.orEmpty(),
            longName = longName.orEmpty(),
            shortName = shortName.orEmpty(),
        )
    }
}
