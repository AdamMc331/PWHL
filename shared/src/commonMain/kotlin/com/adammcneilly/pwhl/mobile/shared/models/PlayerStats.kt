package com.adammcneilly.pwhl.mobile.shared.models

data class PlayerStats(
    val team: Team,
    val player: Player,
    val stats: Stats,
    val isGoalie: Boolean,
)
