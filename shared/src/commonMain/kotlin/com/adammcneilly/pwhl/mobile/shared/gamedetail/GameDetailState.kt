package com.adammcneilly.pwhl.mobile.shared.gamedetail

import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameSummaryDisplayModel

data class GameDetailState(
    val isLoading: Boolean,
    val game: GameSummaryDisplayModel?,
) {
    val teamMatchUp: String
        get() = "${game?.homeTeam?.shortCode} vs ${game?.awayTeam?.shortCode}"

    companion object {
        val Default = GameDetailState(
            isLoading = false,
            game = null,
        )
    }
}
