package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.GameDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechScoreBarResponseDTO(
    @SerialName("SiteKit")
    val siteKit: HockeyTechSiteKitDTO? = null,
) {
    fun parseGames(): List<GameDetail> {
        return siteKit
            ?.scoreBar
            ?.mapNotNull { scoreBarItem ->
                scoreBarItem?.parseGame()
            }.orEmpty()
    }
}
