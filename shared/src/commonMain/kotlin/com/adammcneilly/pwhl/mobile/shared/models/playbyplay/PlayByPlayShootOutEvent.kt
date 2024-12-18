package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player
import com.adammcneilly.pwhl.mobile.shared.models.Team

data class PlayByPlayShootOutEvent(
    val shooter: Player,
    val goalie: Player,
    val shooterTeam: Team,
    val isGoal: Boolean,
    val isGameWinningGoal: Boolean,
    override val period: Period,
    override val time: String,
) : PlayByPlayEvent
