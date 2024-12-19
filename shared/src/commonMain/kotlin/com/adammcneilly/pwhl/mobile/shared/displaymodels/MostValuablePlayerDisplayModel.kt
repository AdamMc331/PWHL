package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.MostValuablePlayer

data class MostValuablePlayerDisplayModel(
    val team: TeamDisplayModel,
    val player: PlayerDisplayModel,
    val highlightStats: Map<String, String>,
) {
    constructor(mvp: MostValuablePlayer) : this(
        team = TeamDisplayModel(mvp.team),
        player = PlayerDisplayModel(mvp.player),
        highlightStats = mvp.highlightStats(),
    )
}

private fun MostValuablePlayer.highlightStats(): Map<String, String> {
    return if (this.isGoalie) {
        val saves = this.stats.saves?.toFloat() ?: 0F
        val shots = this.stats.shotsAgainst?.toFloat() ?: 0F
        val savePercentage = saves / shots

        mapOf(
            "GA" to this.stats.goalsAgainst.toString(),
            "SV%" to savePercentage.toString(),
        )
    } else {
        mapOf(
            "G" to stats.goals.toString(),
            "A" to stats.assists.toString(),
            "P" to stats.points.toString(),
        )
    }
}
