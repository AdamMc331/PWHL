package com.adammcneilly.pwhl.mobile.shared.gamedetail

import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameDetailDisplayModelV2
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel

data class GameDetailState(
    val isLoading: Boolean,
    val game: GameDetailDisplayModelV2?,
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
