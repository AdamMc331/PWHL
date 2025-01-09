package com.adammcneilly.pwhl.mobile.shared.gamedetail

sealed interface GameDetailUiEvent {
    data class MvpClicked(
        val playerId: String,
    ) : GameDetailUiEvent
}
