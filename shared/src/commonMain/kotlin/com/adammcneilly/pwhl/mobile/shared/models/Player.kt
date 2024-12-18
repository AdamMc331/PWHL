package com.adammcneilly.pwhl.mobile.shared.models

data class Player(
    val id: String,
    val jerseyNumber: Int,
    val firstName: String,
    val lastName: String,
    val position: String,
    val birthDate: String,
    val playerImageURL: String?,
) {
    val fullName: String
        get() = "$firstName $lastName"

    val fullNameWithNumber: String
        get() = "#$jerseyNumber $fullName"
}
