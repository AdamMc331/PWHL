package com.adammcneilly.pwhl.mobile.shared.data.remote

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

/**
 * Creates an [HttpClientEngine] for the iOS platform.
 */
actual fun provideHttpClientEngine(): HttpClientEngine {
    return Darwin.create()
}
