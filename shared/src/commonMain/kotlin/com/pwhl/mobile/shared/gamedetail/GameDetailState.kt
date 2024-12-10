package com.pwhl.mobile.shared.gamedetail

import com.pwhl.mobile.shared.displaymodels.GameSummaryDisplayModel

data class GameDetailState(
    val isLoading: Boolean,
    val game: GameSummaryDisplayModel?,
) {
    companion object {
        val Default = GameDetailState(
            isLoading = false,
            game = null,
        )
    }
}
