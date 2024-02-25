package app.roleparty.configuration

import app.roleparty.adapter.secondary.CampaignRepositoryPostgresAdapter
import app.roleparty.application.CreateCampaignService
import app.roleparty.port.primary.CreateCampaign
import app.roleparty.port.secondary.CampaignRepository
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

object DependencyInjectionApplicationConfigurer : ApplicationConfigurer {

    private val ports = module {
        single<CampaignRepository> { CampaignRepositoryPostgresAdapter() }
    }

    private val services = module {
        single<CreateCampaign> { CreateCampaignService(get()) }
    }

    context(Application)
    override fun configure() {
        install(Koin) {
            slf4jLogger()
            modules(ports)
            modules(services)
        }
    }
}

