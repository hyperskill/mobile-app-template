package org.hyperskill.example

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform