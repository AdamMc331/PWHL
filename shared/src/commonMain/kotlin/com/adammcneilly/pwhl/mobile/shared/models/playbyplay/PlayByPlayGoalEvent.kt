package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.LocalTeamImageProvider
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player
import com.adammcneilly.pwhl.mobile.shared.models.PlayerAndAssistCount
import com.adammcneilly.pwhl.mobile.shared.models.PlayerAndGoalCount

data class PlayByPlayGoalEvent(
    val scoredBy: PlayerAndGoalCount,
    val teamId: String,
    val assistingPlayers: List<PlayerAndAssistCount>,
    val plusPlayers: List<Player>,
    val minusPlayers: List<Player>,
    override val period: Period,
    override val time: String,
    override val xLocation: Int?,
    override val yLocation: Int?,
) : PlayByPlayEvent {
    override val type: PlayByPlayEvent.Type = PlayByPlayEvent.Type.GOAL

    override fun toDisplayModel(): PlayByPlayEventDisplayModel {
        val scoreDescription = "${scoredBy.player.fullNameWithNumber} (${scoredBy.goalCount})"

        val assistsWithCounts = assistingPlayers.joinToString(", ") { (player, assistCount) ->
            "${player.fullNameWithNumber} ($assistCount)"
        }

        val assistDescription = if (assistsWithCounts.isEmpty()) {
            "None"
        } else {
            assistsWithCounts
        }

        val plusPlayers = buildString {
            append("Plus")
            append("\n")
            val playerNames = plusPlayers.joinToString("\n") { player ->
                player.fullNameWithNumber
            }
            append(playerNames)
        }

        return PlayByPlayEventDisplayModel(
            teamImage = LocalTeamImageProvider.getTeamImage(teamId),
            time = time,
            title = "GOAL",
            description = "$scoreDescription ASST: $assistDescription",
            period = period,
            xLocation = xLocation,
            yLocation = yLocation,
            teamId = teamId,
            type = type,
            expandedDescription = plusPlayers,
        )
    }
}
