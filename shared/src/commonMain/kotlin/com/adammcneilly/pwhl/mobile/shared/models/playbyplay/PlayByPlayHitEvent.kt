package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player

data class PlayByPlayHitEvent(
    val player: Player,
    override val period: Period,
    override val time: String,
) : PlayByPlayEvent
