package org.hyperskill.example.network.injection

import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json
import org.hyperskill.example.base.injection.CommonComponent
import org.hyperskill.example.network.NetworkBuilder

fun NetworkComponent(
    commonComponent: CommonComponent
): NetworkComponent =
    NetworkComponentImpl(commonComponent)

private class NetworkComponentImpl(
    private val commonComponent: CommonComponent
) : NetworkComponent {

    private val networkJson = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }

    override val httpClient: HttpClient
        get() = NetworkBuilder.buildHttpClient(
            json = networkJson,
            buildVariant = commonComponent.buildVariant,
            platform = commonComponent.platform
        )
}