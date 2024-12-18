package com.adammcneilly.pwhl.mobile.shared.gamedetail

import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameSummaryDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayerDisplayModel

data class GameDetailState(
    val isLoading: Boolean,
    val game: GameSummaryDisplayModel?,
    val playByPlayEvents: Map<String, List<PlayByPlayEventDisplayModel>>,
    val mostValuablePlayers: List<PlayerDisplayModel>,
) {
    companion object {
        val Default = GameDetailState(
            isLoading = false,
            game = null,
            playByPlayEvents = emptyMap(),
            mostValuablePlayers = emptyList(),
        )
    }
}
