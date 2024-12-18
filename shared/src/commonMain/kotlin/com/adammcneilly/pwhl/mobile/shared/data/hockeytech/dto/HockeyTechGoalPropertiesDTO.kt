package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGoalPropertiesDTO(
    @SerialName("isEmptyNet")
    val isEmptyNet: String? = null,
    @SerialName("isGameWinningGoal")
    val isGameWinningGoal: String? = null,
    @SerialName("isInsuranceGoal")
    val isInsuranceGoal: String? = null,
    @SerialName("isPenaltyShot")
    val isPenaltyShot: String? = null,
    @SerialName("isPowerPlay")
    val isPowerPlay: String? = null,
    @SerialName("isShortHanded")
    val isShortHanded: String? = null,
)
