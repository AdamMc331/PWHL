package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player
import com.adammcneilly.pwhl.mobile.shared.models.Team

data class PlayByPlayGoalEvent(
    val scoredBy: Player,
    val team: Team,
    val assists: List<Player>,
    override val period: Period,
    override val time: String,
) : PlayByPlayEvent
