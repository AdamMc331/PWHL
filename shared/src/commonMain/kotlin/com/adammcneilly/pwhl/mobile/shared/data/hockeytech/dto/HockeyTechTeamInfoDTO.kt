package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.Team
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechTeamInfoDTO(
    @SerialName("abbreviation")
    val abbreviation: String? = null,
    @SerialName("city")
    val city: String? = null,
    @SerialName("conferenceName")
    val conferenceName: String? = null,
    @SerialName("divisionName")
    val divisionName: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("logo")
    val logo: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("nickname")
    val nickname: String? = null,
) {
    fun parseTeam(): Team {
        return Team(
            id = id.toString(),
            name = name.orEmpty(),
            city = city.orEmpty(),
            shortCode = abbreviation.orEmpty(),
            imageUrl = logo,
        )
    }
}
