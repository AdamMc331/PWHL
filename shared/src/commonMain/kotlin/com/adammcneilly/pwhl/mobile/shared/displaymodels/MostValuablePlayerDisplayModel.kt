package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.MostValuablePlayer

data class MostValuablePlayerDisplayModel(
    val team: TeamDisplayModel,
    val player: PlayerDisplayModel,
) {
    constructor(mvp: MostValuablePlayer) : this(
        team = TeamDisplayModel(mvp.team),
        player = PlayerDisplayModel(mvp.player),
    )
}
