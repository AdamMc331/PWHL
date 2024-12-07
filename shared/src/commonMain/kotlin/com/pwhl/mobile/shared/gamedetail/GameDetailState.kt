package com.pwhl.mobile.shared.gamedetail

import com.pwhl.mobile.shared.displaymodels.GameDisplayModel

data class GameDetailState(
    val isLoading: Boolean,
    val game: GameDisplayModel?,
) {
    companion object {
        val Default = GameDetailState(
            isLoading = false,
            game = null,
        )
    }
}
