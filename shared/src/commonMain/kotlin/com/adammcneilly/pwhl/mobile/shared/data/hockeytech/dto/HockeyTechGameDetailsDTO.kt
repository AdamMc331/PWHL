package com.adammcneilly.pwhl.mobile.shared.data.hockeytech.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HockeyTechGameDetailsDTO(
    @SerialName("attendance")
    val attendance: Int? = null,
    @SerialName("date")
    val date: String? = null,
    @SerialName("duration")
    val duration: String? = null,
    @SerialName("endTime")
    val endTime: String? = null,
    @SerialName("final")
    val `final`: String? = null,
    @SerialName("floHockeyUrl")
    val floHockeyUrl: String? = null,
    @SerialName("GameDateISO8601")
    val gameDateISO8601: String? = null,
    @SerialName("gameNumber")
    val gameNumber: String? = null,
    @SerialName("gameReportUrl")
    val gameReportUrl: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("publicNotes")
    val publicNotes: String? = null,
    @SerialName("seasonId")
    val seasonId: String? = null,
    @SerialName("startTime")
    val startTime: String? = null,
    @SerialName("started")
    val started: String? = null,
    @SerialName("status")
    val status: String? = null,
    @SerialName("textBoxscoreUrl")
    val textBoxscoreUrl: String? = null,
    @SerialName("ticketsUrl")
    val ticketsUrl: String? = null,
    @SerialName("venue")
    val venue: String? = null,
)
