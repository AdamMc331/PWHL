package com.adammcneilly.pwhl.mobile.shared.models

data class MostValuablePlayer(
    val team: Team,
    val player: Player,
    val stats: GamePlayerStats,
    val isGoalie: Boolean,
)
