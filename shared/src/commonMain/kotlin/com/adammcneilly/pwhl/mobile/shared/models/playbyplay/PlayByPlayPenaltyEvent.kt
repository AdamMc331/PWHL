package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.LocalTeamImageProvider
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player

data class PlayByPlayPenaltyEvent(
    val againstTeamId: String,
    val description: String,
    val minutes: String,
    val powerPlay: Boolean,
    val servedBy: Player,
    val takenBy: Player?,
    override val period: Period,
    override val time: String,
    override val xLocation: Int?,
    override val yLocation: Int?,
) : PlayByPlayEvent {
    override val type: PlayByPlayEvent.Type = PlayByPlayEvent.Type.PENALTY

    override fun toDisplayModel(): PlayByPlayEventDisplayModel {
        return PlayByPlayEventDisplayModel(
            teamImage = LocalTeamImageProvider.getTeamImage(againstTeamId),
            time = time,
            title = "PENALTY",
            description = "${takenBy?.fullNameWithNumber} – $description",
            period = period,
            xLocation = xLocation,
            yLocation = yLocation,
            teamId = againstTeamId,
            type = type,
        )
    }
}
