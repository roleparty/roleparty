package app.roleparty.application

import app.roleparty.domain.Campaign
import app.roleparty.port.secondary.CampaignRepository
import app.roleparty.port.primary.CreateCampaign
import org.jmolecules.architecture.hexagonal.Application

@Application
data class CreateCampaignService(
    private val campaignRepository: CampaignRepository
) : CreateCampaign {

    override suspend operator fun invoke(campaign: Campaign): Campaign {
        return campaignRepository.save(campaign)
    }
}