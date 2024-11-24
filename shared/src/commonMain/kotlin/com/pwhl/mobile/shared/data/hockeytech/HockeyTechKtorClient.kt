package com.pwhl.mobile.shared.data.hockeytech

import com.pwhl.mobile.shared.BuildKonfig
import com.pwhl.mobile.shared.data.remote.BaseKtorClient

object HockeyTechKtorClient : BaseKtorClient(
    baseURL = "https://lscluster.hockeytech.com/",
) {
    private const val PARAM_KEY_API_KEY = "key"
    private const val PARAM_KEY_CLIENT_CODE = "client_code"
    private const val PARAM_KEY_FORMAT = "fmt"
    private const val PARAM_KEY_SITE_ID = "site_id"
    private const val PARAM_KEY_LEAGUE_ID = "league_id"

    private const val PARAM_VALUE_CLIENT_CODE = "pwhl"
    private const val PARAM_VALUE_FORMAT = "json"
    private const val PARAM_VALUE_SITE_ID = "0"
    private const val PARAM_VALUE_LEAGUE_ID = "1"

    val baseHockeyTechParams = mapOf(
        PARAM_KEY_API_KEY to BuildKonfig.PWHL_API_KEY,
        PARAM_KEY_CLIENT_CODE to PARAM_VALUE_CLIENT_CODE,
        PARAM_KEY_FORMAT to PARAM_VALUE_FORMAT,
        PARAM_KEY_SITE_ID to PARAM_VALUE_SITE_ID,
        PARAM_KEY_LEAGUE_ID to PARAM_VALUE_LEAGUE_ID,
    )
}
