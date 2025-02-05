package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.LocalTeamImageProvider
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player

data class PlayByPlayShotEvent(
    val goalie: Player,
    val shooter: Player,
    val shooterTeamId: String,
    val isGoal: Boolean,
    override val period: Period,
    override val time: String,
    override val xLocation: Int?,
    override val yLocation: Int?,
) : PlayByPlayEvent {
    override val type: PlayByPlayEvent.Type = PlayByPlayEvent.Type.SHOT

    override fun toDisplayModel(): PlayByPlayEventDisplayModel {
        return PlayByPlayEventDisplayModel(
            teamImage = LocalTeamImageProvider.getTeamImage(shooterTeamId),
            time = time,
            title = "SHOT",
            description = "${shooter.fullNameWithNumber} Shoots On ${goalie.fullNameWithNumber}",
            period = period,
            xLocation = xLocation,
            yLocation = yLocation,
            teamId = shooterTeamId,
            type = type,
        )
    }
}
