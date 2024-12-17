package com.adammcneilly.pwhl.mobile.shared.gamedetail

enum class GameDetailTab {
    Summary,
    Stats,
    PlayByPlay,
    ;

    fun getLabel(): String {
        return when (this) {
            Summary -> "Summary"
            Stats -> "Stats"
            PlayByPlay -> "Play by Play"
        }
    }
}
