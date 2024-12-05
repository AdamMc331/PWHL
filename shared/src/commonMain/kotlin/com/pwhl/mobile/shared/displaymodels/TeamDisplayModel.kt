package com.pwhl.mobile.shared.displaymodels

import com.pwhl.mobile.shared.Res
import com.pwhl.mobile.shared.boston
import com.pwhl.mobile.shared.minnesota
import com.pwhl.mobile.shared.models.Team
import com.pwhl.mobile.shared.montreal
import com.pwhl.mobile.shared.newyork
import com.pwhl.mobile.shared.ottawa
import com.pwhl.mobile.shared.pwhl
import com.pwhl.mobile.shared.toronto

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
        image = team.image(),
    )
}

private fun Team.image(): ImageDisplayModel {
    return remoteImage() ?: localImage()
}

private fun Team.remoteImage(): ImageDisplayModel? {
    return this.imageUrl?.let(ImageDisplayModel::Remote)
}

private fun Team.localImage(): ImageDisplayModel.Local {
    val res = when (this.id) {
        "1" -> Res.drawable.boston
        "2" -> Res.drawable.minnesota
        "3" -> Res.drawable.montreal
        "4" -> Res.drawable.newyork
        "5" -> Res.drawable.ottawa
        "6" -> Res.drawable.toronto
        else -> Res.drawable.pwhl
    }

    return ImageDisplayModel.Local(res)
}
