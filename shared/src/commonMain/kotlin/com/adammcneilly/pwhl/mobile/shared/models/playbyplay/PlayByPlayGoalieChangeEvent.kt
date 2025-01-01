package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.LocalTeamImageProvider
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player

data class PlayByPlayGoalieChangeEvent(
    val goalieComingIn: Player?,
    val goalieComingOut: Player?,
    val teamId: String,
    override val period: Period,
    override val time: String,
    override val xLocation: Int?,
    override val yLocation: Int?,
) : PlayByPlayEvent {
    override fun toDisplayModel(): PlayByPlayEventDisplayModel {
        val goalieInDescription = goalieComingIn?.fullNameWithNumber?.let { player ->
            "$player On"
        }

        val goalieOutDescription = goalieComingOut?.fullNameWithNumber?.let { player ->
            "$player Off"
        }

        val description = listOfNotNull(
            goalieInDescription,
            goalieOutDescription,
        ).joinToString("\n")

        return PlayByPlayEventDisplayModel(
            teamImage = LocalTeamImageProvider.getTeamImage(teamId),
            time = time,
            title = "GOALIE CHANGE",
            description = description,
            period = period,
            xLocation = xLocation,
            yLocation = yLocation,
        )
    }
}
