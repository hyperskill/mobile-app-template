package org.hyperskill.example.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.hyperskill.example.base.model.BuildVariant
import org.hyperskill.example.base.model.Platform
import org.hyperskill.example.netwrork.NetworkBuildConfig

internal object NetworkBuilder {

    fun buildHttpClient(
        json: Json,
        buildVariant: BuildVariant,
        platform: Platform
    ): HttpClient =
        HttpClient {
            defaultRequest {
                url {
                    protocol = URLProtocol.createOrDefault(NetworkBuildConfig.PROTOCOL)
                    host = NetworkBuildConfig.BASE_URL
                    path(NetworkBuildConfig.BASE_PATH)
                }
            }
            install(ContentNegotiation) {
                json(json)
            }
            if (buildVariant != BuildVariant.RELEASE) {
                install(Logging) {
                    logger = Logger.SIMPLE
                    level = LogLevel.ALL
                }
            }
            install(UserAgent) {
                agent = platform.userAgent()
            }
        }
}

private fun Platform.userAgent(): String =
    "Example-Mobile/$versionName ($osVersion) build/$versionCode package/$applicationId"