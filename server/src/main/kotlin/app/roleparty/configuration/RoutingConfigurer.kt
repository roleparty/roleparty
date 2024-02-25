package app.roleparty.configuration

import app.roleparty.adapter.primary.campaignRoutes
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

object RoutingConfigurer : ApplicationConfigurer {

    context(Application)
    override fun configure() {
        routing {
            campaignRoutes()
        }
    }
}