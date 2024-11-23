package com.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechCopyrightDTO(
    @SerialName("powered_by")
    val poweredBy: String? = null,
    @SerialName("powered_by_url")
    val poweredByUrl: String? = null,
    @SerialName("required_copyright")
    val requiredCopyright: String? = null,
    @SerialName("required_link")
    val requiredLink: String? = null,
)
