package app.roleparty.configuration

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import kotlinx.serialization.json.Json

object ContentNegotiationApplicationConfigurer : ApplicationConfigurer {

    context(Application)
    override fun configure() {
        install(ContentNegotiation) {
            json(Json)
        }
    }
}