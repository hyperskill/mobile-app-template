package org.hyperskill.example.network.injection

import io.ktor.client.HttpClient

interface NetworkComponent {
    val httpClient: HttpClient
}