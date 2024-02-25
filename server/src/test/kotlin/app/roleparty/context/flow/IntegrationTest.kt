package app.roleparty.context.flow

import app.roleparty.adapter.primary.campaignRoutes
import app.roleparty.adapter.secondary.CampaignRepositoryPostgresAdapter
import app.roleparty.application.CreateCampaignService
import app.roleparty.port.primary.CreateCampaign
import app.roleparty.port.secondary.CampaignRepository
import io.ktor.client.HttpClient
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation as ServerContentNegotiation
import io.ktor.server.testing.ApplicationTestBuilder
import io.ktor.server.testing.testApplication
import kotlin.coroutines.EmptyCoroutineContext
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation.Plugin as ClientContentNegotiation

/**
 * Configures the application and runs the given [block] with a configured [HttpClient].
 */
fun testConfiguredApplication(block: suspend ApplicationTestBuilder.(configuredClient: HttpClient) -> Unit) {
    testApplication(
        parentCoroutineContext = EmptyCoroutineContext,
        block = {
            configureApplication()
            block(createClient())
        }
    )
}

/**
 * Configures the application with the same configuration as the server.
 */
private fun ApplicationTestBuilder.configureApplication() {
    install(Koin) {
        modules(
            module {
                single<CampaignRepository> { CampaignRepositoryPostgresAdapter() }
                single<CreateCampaign> { CreateCampaignService(get()) }
            }
        )
    }
    routing {
        campaignRoutes()
    }
    install(ServerContentNegotiation) {
        json()
    }
}

/**
 * Creates a [HttpClient] with the same configuration as the server.
 */
private fun ApplicationTestBuilder.createClient() = createClient {
    install(ClientContentNegotiation) {
        json()
    }
}