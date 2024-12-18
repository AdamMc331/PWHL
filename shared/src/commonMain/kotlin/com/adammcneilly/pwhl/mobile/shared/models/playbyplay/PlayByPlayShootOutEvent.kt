package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.TeamDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player
import com.adammcneilly.pwhl.mobile.shared.models.Team

data class PlayByPlayShootOutEvent(
    val shooter: Player,
    val goalie: Player,
    val shooterTeam: Team,
    val isGoal: Boolean,
    val isGameWinningGoal: Boolean,
    override val period: Period,
    override val time: String,
) : PlayByPlayEvent {
    override fun toDisplayModel(): PlayByPlayEventDisplayModel {
        return PlayByPlayEventDisplayModel(
            teamImage = TeamDisplayModel(shooterTeam).image,
            time = time,
            title = "SHOOTOUT",
            description = "${shooter.fullNameWithNumber} Shootout Attempt On ${goalie.fullNameWithNumber}",
            period = period,
        )
    }
}
