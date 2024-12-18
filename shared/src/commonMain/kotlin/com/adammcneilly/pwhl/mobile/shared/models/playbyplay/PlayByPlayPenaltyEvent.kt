package com.adammcneilly.pwhl.mobile.shared.models.playbyplay

import com.adammcneilly.pwhl.mobile.shared.models.Period
import com.adammcneilly.pwhl.mobile.shared.models.Player
import com.adammcneilly.pwhl.mobile.shared.models.Team

data class PlayByPlayPenaltyEvent(
    val againstTeam: Team,
    val description: String,
    val minutes: String,
    val powerPlay: Boolean,
    val servedBy: Player,
    val takenBy: Player?,
    override val period: Period,
    override val time: String,
) : PlayByPlayEvent
