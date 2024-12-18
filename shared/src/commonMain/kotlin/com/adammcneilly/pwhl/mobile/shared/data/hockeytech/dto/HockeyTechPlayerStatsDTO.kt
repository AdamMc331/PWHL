package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechPlayerStatsDTO(
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
    @SerialName("hits")
    val hits: Int? = null,
    @SerialName("penaltyMinutes")
    val penaltyMinutes: Int? = null,
    @SerialName("plusMinus")
    val plusMinus: Int? = null,
    @SerialName("points")
    val points: Int? = null,
    @SerialName("shots")
    val shots: Int? = null,
    @SerialName("toi")
    val toi: String? = null,
)
