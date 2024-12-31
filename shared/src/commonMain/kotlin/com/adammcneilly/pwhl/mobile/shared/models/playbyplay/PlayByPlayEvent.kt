package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.Period

sealed interface PlayByPlayEvent {
    val period: Period
    val time: String
    val xLocation: Int?
    val yLocation: Int?

    fun toDisplayModel(): PlayByPlayEventDisplayModel
}
