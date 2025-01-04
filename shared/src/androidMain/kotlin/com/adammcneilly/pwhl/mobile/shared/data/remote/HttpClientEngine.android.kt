package com.adammcneilly.pwhl.mobile.shared.data.remote

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android

/**
 * Return an [HttpClientEngine] for the Android platform.
 */
actual fun provideHttpClientEngine(): HttpClientEngine {
    return Android.create()
}
