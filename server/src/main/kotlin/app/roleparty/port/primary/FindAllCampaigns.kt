package app.roleparty.port.primary

import app.roleparty.domain.Campaign
import org.jmolecules.architecture.hexagonal.PrimaryPort

@PrimaryPort
interface FindAllCampaigns {

    suspend operator fun invoke(campaign: Campaign): Campaign
}