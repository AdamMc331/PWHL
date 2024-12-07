package com.pwhl.mobile.shared.data.hockeytech

import com.pwhl.mobile.shared.BuildKonfig
import com.pwhl.mobile.shared.data.remote.BaseKtorClient

object HockeyTechKtorClient : BaseKtorClient(
    baseURL = "https://lscluster.hockeytech.com/",
) {
    val baseHockeyTechParams = mapOf(
        HockeyTechParameterKeys.API_KEY to BuildKonfig.PWHL_API_KEY,
        HockeyTechParameterKeys.CLIENT_CODE to HockeyTechParameterValues.CLIENT_CODE,
        HockeyTechParameterKeys.FORMAT to HockeyTechParameterValues.JSON_FORMAT,
        HockeyTechParameterKeys.SITE_ID to HockeyTechParameterValues.SITE_ID,
        HockeyTechParameterKeys.LEAGUE_ID to HockeyTechParameterValues.LEAGUE_ID,
    )
}
