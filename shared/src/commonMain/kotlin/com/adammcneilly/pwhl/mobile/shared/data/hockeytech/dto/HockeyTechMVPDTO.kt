package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechMVPDTO(
    @SerialName("isGoalie")
    val isGoalie: Boolean? = null,
    @SerialName("player")
    val player: HockeyTechPlayerGameResultDTO? = null,
    @SerialName("playerImage")
    val playerImage: String? = null,
    @SerialName("team")
    val team: HockeyTechTeamInfoDTO? = null,
)
