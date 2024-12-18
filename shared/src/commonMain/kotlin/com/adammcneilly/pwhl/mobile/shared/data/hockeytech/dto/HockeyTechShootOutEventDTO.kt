package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayShootOutEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechShootOutEventDTO(
    @SerialName("details")
    val details: Details? = null,
    @SerialName("event")
    val event: String? = null,
) : HockeyTechPlayByPlayEventDTO {
    override fun toPlayByPlayEvent(): PlayByPlayEvent {
        require(details != null) {
            "Cannot parse shootout event without details."
        }

        require(details.shooter != null) {
            "Cannot parse shootout event without shooter."
        }

        require(details.goalie != null) {
            "Cannot parse shootout event without goalie."
        }

        require(details.shooterTeam != null) {
            "Cannot parse shootout event without shooter team."
        }

        return PlayByPlayShootOutEvent(
            shooter = details.shooter.parsePlayer(),
            goalie = details.goalie.parsePlayer(),
            shooterTeam = details.shooterTeam.parseTeam(),
            isGoal = details.isGoal == true,
            isGameWinningGoal = details.isGameWinningGoal == true,
            period = Period.Shootout,
            time = "",
        )
    }

    @Serializable
    data class Details(
        @SerialName("goalie")
        val goalie: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("isGameWinningGoal")
        val isGameWinningGoal: Boolean? = null,
        @SerialName("isGoal")
        val isGoal: Boolean? = null,
        @SerialName("shooter")
        val shooter: HockeyTechPlayerSummaryDTO? = null,
        @SerialName("shooterTeam")
        val shooterTeam: HockeyTechTeamInfoDTO? = null,
    )
}
