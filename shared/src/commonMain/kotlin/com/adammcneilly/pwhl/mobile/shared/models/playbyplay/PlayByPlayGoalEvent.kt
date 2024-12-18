package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.TeamDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player
import com.adammcneilly.pwhl.mobile.shared.models.Team

data class PlayByPlayGoalEvent(
    val scoredBy: Player,
    val team: Team,
    val assists: List<Player>,
    override val period: Period,
    override val time: String,
) : PlayByPlayEvent {
    override fun toDisplayModel(): PlayByPlayEventDisplayModel {
        // #13 Tereza Vanišová (1) ASST: #2 Aneta Tejralová (1)
        return PlayByPlayEventDisplayModel(
            teamImage = TeamDisplayModel(team).image,
            time = time,
            title = "GOAL",
            description = "TODO",
        )
    }
}
