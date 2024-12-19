package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.MostValuablePlayer

data class MostValuablePlayerDisplayModel(
    val team: TeamDisplayModel,
    val player: PlayerDisplayModel,
    val highlightStats: List<StatDisplayModel>,
) {
    constructor(mvp: MostValuablePlayer) : this(
        team = TeamDisplayModel(mvp.team),
        player = PlayerDisplayModel(mvp.player),
        highlightStats = mvp.highlightStats(),
    )
}

private fun MostValuablePlayer.highlightStats(): List<StatDisplayModel> {
    return if (this.isGoalie) {
        val saves = this.stats.saves?.toFloat() ?: 0F
        val shots = this.stats.shotsAgainst?.toFloat() ?: 0F
        val savePercentage = saves / shots

        listOf(
            StatDisplayModel("GA", this.stats.goalsAgainst.toString()),
            StatDisplayModel("SV%", savePercentage.toString()),
        )
    } else {
        listOf(
            StatDisplayModel("G", stats.goals.toString()),
            StatDisplayModel("A", stats.assists.toString()),
            StatDisplayModel("P", stats.points.toString()),
        )
    }
}
