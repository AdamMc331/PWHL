package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.LocalTeamImageProvider
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player

data class PlayByPlayGoalEvent(
    val scoredBy: Player,
    val scoredByGoalCount: Int,
    val teamId: String,
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

        println("ADAMLOG - TEAM: $teamId")

        return PlayByPlayEventDisplayModel(
            teamImage = LocalTeamImageProvider.getTeamImage(teamId),
            time = time,
            title = "GOAL",
            description = "$scoreDescription ASST: $assistDescription",
        )
    }
}
