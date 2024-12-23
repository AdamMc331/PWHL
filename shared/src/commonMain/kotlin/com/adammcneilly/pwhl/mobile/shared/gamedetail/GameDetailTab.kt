package com.adammcneilly.pwhl.mobile.shared.gamedetail

/**
 * Enumeration of the tabs that will appear on the game detail screen.
 */
enum class GameDetailTab {
    Summary,
    Stats,
    PlayByPlay,
    ;

    /**
     * Returns a user friendly string representation of the tab.
     */
    fun getLabel(): String {
        return when (this) {
            Summary -> "Summary"
            Stats -> "Stats"
            PlayByPlay -> "Play By Play"
        }
    }
}
