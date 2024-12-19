package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.models.Player

data class PlayerDisplayModel(
    val fullName: String,
    val jerseyNumber: String,
    val position: String,
    val playerImage: ImageDisplayModel?,
) {
    constructor(
        player: Player,
    ) : this(
        fullName = "${player.firstName} ${player.lastName}",
        jerseyNumber = player.jerseyNumber.toString(),
        position = player.position,
        playerImage = player.playerImageURL?.let { imageUrl ->
            ImageDisplayModel.Remote(imageUrl)
        },
    )
}
