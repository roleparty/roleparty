package app.roleparty.service

import app.roleparty.resource.createCampaign
import io.ktor.client.*
import io.ktor.client.call.*

suspend fun HttpClient.createCampaign(): String {
    val response = createCampaign.call()
    return response.body<String>()
}