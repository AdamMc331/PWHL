package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player

data class PlayByPlayBlockedShotEvent(
    val blocker: Player,
    val goalie: Player?,
    val shooter: Player,
    override val period: Period,
    override val time: String,
) : PlayByPlayEvent
