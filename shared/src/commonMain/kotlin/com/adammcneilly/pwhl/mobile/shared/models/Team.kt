package com.adammcneilly.pwhl.mobile.shared.models

data class Team(
    val id: String,
    val name: String,
    val city: String,
    val shortCode: String,
    val imageUrl: String?,
)
