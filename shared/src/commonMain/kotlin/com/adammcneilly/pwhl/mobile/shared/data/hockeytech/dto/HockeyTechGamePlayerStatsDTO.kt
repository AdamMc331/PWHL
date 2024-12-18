package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import com.adammcneilly.pwhl.mobile.shared.models.GamePlayerStats
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGamePlayerStatsDTO(
    @SerialName("assists")
    val assists: Int? = null,
    @SerialName("blockedShots")
    val blockedShots: Int? = null,
    @SerialName("faceoffAttempts")
    val faceoffAttempts: Int? = null,
    @SerialName("faceoffWins")
    val faceoffWins: Int? = null,
    @SerialName("goals")
    val goals: Int? = null,
    @SerialName("goalsAgainst")
    val goalsAgainst: Int? = null,
    @SerialName("hits")
    val hits: Int? = null,
    @SerialName("penaltyMinutes")
    val penaltyMinutes: Int? = null,
    @SerialName("plusMinus")
    val plusMinus: Int? = null,
    @SerialName("points")
    val points: Int? = null,
    @SerialName("saves")
    val saves: Int? = null,
    @SerialName("shots")
    val shots: Int? = null,
    @SerialName("shotsAgainst")
    val shotsAgainst: Int? = null,
    @SerialName("toi")
    val toi: String? = null,
) {

    fun parseGamePlayerStats(): GamePlayerStats {
        return GamePlayerStats(
            assists = assists ?: 0,
            goals = goals ?: 0,
            points = points ?: 0,
            shotsAgainst = shotsAgainst,
            goalsAgainst = goalsAgainst,
            saves = saves,
        )
    }
}
