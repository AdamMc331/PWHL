package com.pwhl.mobile.shared.data.hockeytech.dto

import com.pwhl.mobile.shared.models.Game
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechScoreBarResponseDTO(
    @SerialName("SiteKit")
    val siteKit: HockeyTechSiteKitDTO? = null,
) {
    fun parseGames(): List<Game> {
        return siteKit
            ?.scoreBar
            ?.mapNotNull { scoreBarItem ->
                scoreBarItem?.parseGame()
            }.orEmpty()
    }
}
