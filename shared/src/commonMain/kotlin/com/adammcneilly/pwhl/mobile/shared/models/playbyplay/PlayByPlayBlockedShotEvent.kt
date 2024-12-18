package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.LocalTeamImageProvider
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player

data class PlayByPlayBlockedShotEvent(
    val blocker: Player,
    val goalie: Player?,
    val shooter: Player,
    val shooterTeamId: String,
    override val period: Period,
    override val time: String,
) : PlayByPlayEvent {
    override fun toDisplayModel(): PlayByPlayEventDisplayModel {
        val shooterNumber = shooter.jerseyNumber
        val blockerNumber = blocker.jerseyNumber

        val shooterName = shooter.fullName
        val blockerName = blocker.fullName

        val shooter = "#$shooterNumber $shooterName"
        val blocker = "#$blockerNumber $blockerName"

        val description = "$shooter Blocked By $blocker"

        return PlayByPlayEventDisplayModel(
            teamImage = LocalTeamImageProvider.getTeamImage(shooterTeamId),
            time = time,
            title = "BLOCKED SHOT",
            description = description,
            period = period,
        )
    }
}
