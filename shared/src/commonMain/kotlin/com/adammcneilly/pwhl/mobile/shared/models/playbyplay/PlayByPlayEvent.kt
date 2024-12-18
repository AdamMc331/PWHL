package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.models.Period

sealed interface PlayByPlayEvent {
    val period: Period
    val time: String
}
