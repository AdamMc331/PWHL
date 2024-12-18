package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.TeamDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player
import com.adammcneilly.pwhl.mobile.shared.models.Team

data class PlayByPlayGoalEvent(
    val scoredBy: Player,
    val scoredByGoalCount: Int,
    val team: Team,
    val assistingPlayers: List<Pair<Player, Int>>,
    override val period: Period,
    override val time: String,
) : PlayByPlayEvent {
    override fun toDisplayModel(): PlayByPlayEventDisplayModel {
        val scoreDescription = "${scoredBy.fullNameWithNumber} ($scoredByGoalCount)"

        val assistsWithCounts = assistingPlayers.joinToString(", ") { (player, assistCount) ->
            "${player.fullNameWithNumber} ($assistCount)"
        }

        val assistDescription = if (assistsWithCounts.isEmpty()) {
            "None"
        } else {
            assistsWithCounts
        }

        return PlayByPlayEventDisplayModel(
            teamImage = TeamDisplayModel(team).image,
            time = time,
            title = "GOAL",
            description = "$scoreDescription ASST: $assistDescription",
        )
    }
}
