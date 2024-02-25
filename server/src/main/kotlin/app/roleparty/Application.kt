package app.roleparty

import app.roleparty.configuration.ContentNegotiationApplicationConfigurer
import app.roleparty.configuration.DatabaseApplicationConfigurer
import app.roleparty.configuration.DependencyInjectionApplicationConfigurer
import app.roleparty.configuration.RoutingConfigurer
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    listOf(
        DependencyInjectionApplicationConfigurer,
        DatabaseApplicationConfigurer,
        ContentNegotiationApplicationConfigurer,
        RoutingConfigurer
    ).forEach {
        it.configure()
    }
}