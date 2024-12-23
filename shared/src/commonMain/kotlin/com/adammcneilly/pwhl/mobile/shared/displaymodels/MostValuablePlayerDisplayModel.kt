package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.MostValuablePlayer
import com.adammcneilly.pwhl.mobile.shared.util.numberFormatter

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
    val numberFormatter = numberFormatter()

    return if (this.isGoalie) {
        val saves = this.stats.saves?.toFloat() ?: 0F
        val shots = this.stats.shotsAgainst?.toFloat() ?: 0F
        val savePercentage = saves / shots

        listOf(
            StatDisplayModel(
                shortCode = "GA",
                fullName = "Goals Against",
                value = this.stats.goalsAgainst.toString(),
            ),
            StatDisplayModel(
                shortCode = "SV%",
                fullName = "Save Percentage",
                value = numberFormatter.formatSavePercentage(savePercentage),
            ),
        )
    } else {
        listOf(
            StatDisplayModel(
                shortCode = "G",
                fullName = "Goals",
                value = stats.goals.toString(),
            ),
            StatDisplayModel(
                shortCode = "A",
                fullName = "Assists",
                value = stats.assists.toString(),
            ),
            StatDisplayModel(
                shortCode = "P",
                fullName = "Points",
                value = stats.points.toString(),
            ),
        )
    }
}
