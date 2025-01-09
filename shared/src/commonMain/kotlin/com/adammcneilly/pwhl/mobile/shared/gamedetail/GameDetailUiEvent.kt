package com.adammcneilly.pwhl.mobile.shared.gamedetail

import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel

sealed interface GameDetailUiEvent {
    data class MvpClicked(
        val playerId: String,
    ) : GameDetailUiEvent

    data class PlayByPlayClicked(
        val item: PlayByPlayEventDisplayModel,
    ) : GameDetailUiEvent
}
