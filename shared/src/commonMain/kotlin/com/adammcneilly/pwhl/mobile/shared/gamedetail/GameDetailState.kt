package com.adammcneilly.pwhl.mobile.shared.gamedetail

import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameDetailDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel

data class GameDetailState(
    val isLoading: Boolean,
    val game: GameDetailDisplayModel?,
    val playByPlayEvents: Map<String, List<PlayByPlayEventDisplayModel>>,
) {
    companion object {
        val Default = GameDetailState(
            isLoading = false,
            game = null,
            playByPlayEvents = emptyMap(),
        )
    }
}
