package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.MostValuablePlayer
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
) {
    fun parseMostValuablePlayer(): MostValuablePlayer {
        require(team != null) {
            "Cannot parse MVP without team."
        }

        require(player?.info != null) {
            "Cannot parse MVP without player info."
        }

        require(player.stats != null) {
            "Cannot parse MVP without player stats."
        }

        return MostValuablePlayer(
            team = team.parseTeam(),
            player = player.info.parsePlayer(),
            stats = player.stats.parseGamePlayerStats(),
            isGoalie = isGoalie == true,
        )
    }
}
