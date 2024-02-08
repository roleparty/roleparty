package app.roleparty.service

import io.ktor.client.*
import io.ktor.client.plugins.*

val rolepartyHttpClient = HttpClient {
    defaultRequest {
        url("http://192.168.1.11:8080")
    }
}