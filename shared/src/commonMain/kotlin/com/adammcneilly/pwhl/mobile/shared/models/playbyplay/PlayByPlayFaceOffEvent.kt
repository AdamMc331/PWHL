package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.LocalTeamImageProvider
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player

data class PlayByPlayFaceOffEvent(
    val homePlayer: Player,
    val awayPlayer: Player,
    val homeWin: Boolean,
    override val period: Period,
    override val time: String,
) : PlayByPlayEvent {
    override fun toDisplayModel(): PlayByPlayEventDisplayModel {
        val winnerName = if (homeWin) {
            homePlayer.fullName
        } else {
            awayPlayer.fullName
        }

        val matchUp = "${homePlayer.fullNameWithNumber} vs ${awayPlayer.fullNameWithNumber}"

        return PlayByPlayEventDisplayModel(
            teamImage = LocalTeamImageProvider.getTeamImage("TODO"),
            time = time,
            title = "FACEOFF",
            description = "$matchUp\n$winnerName wins",
            period = period,
        )
    }
}
