package com.adammcneilly.pwhl.mobile.shared.gamedetail

import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameDetailDisplayModel
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel

/**
 * Defines the UI state of the game detail screen.
 */
data class GameDetailState(
    val isLoading: Boolean,
    val game: GameDetailDisplayModel?,
    val playByPlayEvents: Map<String, List<PlayByPlayEventDisplayModel>>,
    val selectedMvpId: String?,
    // TODO: Can we use an Id somehow rather than track the entire displaymodel?
    //  Or some other shortcut into comparing pbp items.
    val selectedPlayByPlayEvent: PlayByPlayEventDisplayModel?,
) {
    // Remove after Detekt is updated: https://github.com/detekt/detekt/pull/7635/
    @Suppress("UndocumentedPublicClass")
    companion object {
        /**
         * Provides a default state for the
         * game detail screen when it is first created.
         */
        val Default = GameDetailState(
            isLoading = false,
            game = null,
            playByPlayEvents = emptyMap(),
            selectedMvpId = null,
            selectedPlayByPlayEvent = null,
        )
    }
}
