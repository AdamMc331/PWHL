package com.adammcneilly.pwhl.mobile.shared

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.fullPath
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel

/**
 * Create a custom [MockEngine] that will determine the response to return based on the supplied
 * mock [responses], which is a key value pair of url to response file names.
 */
fun fakeHttpClientEngine(
    responses: Map<String, String>,
): HttpClientEngine =
    MockEngine {
        val url = it.url.fullPath

        val responseFile = responses[url]

        if (responseFile == null) {
            throw IllegalArgumentException(
                """
                No mock response found for url: $url
                Available urls:
                ${responses.keys.joinToString("\n")}
                """.trimIndent(),
            )
        }

        val responseText = readFile(responseFile)

        respond(
            content = ByteReadChannel(responseText),
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json"),
        )
    }
