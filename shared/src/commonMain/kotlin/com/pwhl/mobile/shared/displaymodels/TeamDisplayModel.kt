package com.pwhl.mobile.shared.displaymodels

import com.pwhl.mobile.shared.models.Team

data class TeamDisplayModel(
    val id: String,
    val city: String,
    val name: String,
    val shortCode: String,
    val image: ImageDisplayModel?,
) {
    constructor(team: Team) : this(
        id = team.id,
        city = team.city,
        name = team.name,
        shortCode = team.shortCode,
        image = team.imageUrl?.let(ImageDisplayModel::Remote),
    )
}
