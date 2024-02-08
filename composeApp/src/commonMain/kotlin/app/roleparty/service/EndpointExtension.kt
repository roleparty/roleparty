package app.roleparty.service

import app.roleparty.resource.HttpEndpoint
import app.roleparty.resource.HttpEndpoint.Method.*
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

context(HttpClient)
suspend fun HttpEndpoint.call(block: HttpRequestBuilder.() -> Unit = {}): HttpResponse = when (method) {
    POST -> post(url, block)
}

fun HttpEndpoint.Method.toHttpMethod() = when (this) {
    POST -> HttpMethod.Post
}