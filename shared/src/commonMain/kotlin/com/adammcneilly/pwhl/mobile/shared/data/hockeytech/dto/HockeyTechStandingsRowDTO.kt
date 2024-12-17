package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechStandingsRowDTO(
    @SerialName("games_played")
    val gamesPlayed: String? = null,
    @SerialName("games_remaining")
    val gamesRemaining: String? = null,
    @SerialName("goals_against")
    val goalsAgainst: String? = null,
    @SerialName("goals_for")
    val goalsFor: String? = null,
    @SerialName("losses")
    val losses: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("non_reg_losses")
    val nonRegLosses: String? = null,
    @SerialName("non_reg_wins")
    val nonRegWins: String? = null,
    @SerialName("overall_rank")
    val overallRank: String? = null,
    @SerialName("percentage")
    val percentage: String? = null,
    @SerialName("points")
    val points: String? = null,
    @SerialName("rank")
    val rank: Int? = null,
    @SerialName("regulation_wins")
    val regulationWins: String? = null,
    @SerialName("team_code")
    val teamCode: String? = null,
)
