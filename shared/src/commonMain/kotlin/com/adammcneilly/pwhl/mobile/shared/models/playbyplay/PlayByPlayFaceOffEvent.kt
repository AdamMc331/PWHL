package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player

data class PlayByPlayFaceOffEvent(
    val homePlayer: Player,
    val awayPlayer: Player,
    val homeWin: Boolean,
    override val period: Period,
    override val time: String,
) : PlayByPlayEvent
