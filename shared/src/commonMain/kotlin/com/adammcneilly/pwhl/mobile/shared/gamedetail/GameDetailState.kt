package com.adammcneilly.pwhl.mobile.shared.gamedetail

import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameSummaryDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel

data class GameDetailState(
    val isLoading: Boolean,
    val game: GameSummaryDisplayModel?,
    val playByPlayEvents: List<PlayByPlayEventDisplayModel>,
) {
    companion object {
        val Default = GameDetailState(
            isLoading = false,
            game = null,
            playByPlayEvents = emptyList(),
        )
    }
}
