package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player

data class PlayByPlayGoalieChangeEvent(
    val goalieComingIn: Player?,
    val goalieComingOut: Player?,
    val teamId: String,
    override val period: Period,
    override val time: String,
) : PlayByPlayEvent
