package app.roleparty.adapter.primary

import app.roleparty.domain.Campaign
import app.roleparty.http.CampaignCreationDto
import app.roleparty.http.CampaignDto
import app.roleparty.port.primary.CreateCampaign
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.respond
import io.ktor.server.routing.*
import java.util.UUID
import org.koin.ktor.ext.inject

fun Routing.campaignRoutes() {
    route("/campaigns") {
        createCampaign()
    }
}

private fun Route.createCampaign() {
    val createCampaign by inject<CreateCampaign>()

    post {
        val campaignCreation = call.receive<CampaignCreationDto>()
        val campaign = createCampaign(campaignCreation.toCampaign())
        call.respond(campaign.toDto())
    }
}

private fun CampaignCreationDto.toCampaign() = Campaign(
    id = Campaign.Id(UUID.randomUUID()),
    title = title,
)

private fun Campaign.toDto() = CampaignDto(
    id = id.value.toString(),
    title = title
)