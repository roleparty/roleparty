package app.roleparty.port.primary

import app.roleparty.domain.Campaign
import org.jmolecules.architecture.hexagonal.PrimaryPort

@PrimaryPort
interface CreateCampaign {

    suspend operator fun invoke(campaign: Campaign): Campaign
}