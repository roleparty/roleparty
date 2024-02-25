package app.roleparty.adapter.secondary

import app.roleparty.configuration.CampaignTable
import app.roleparty.domain.Campaign
import app.roleparty.port.secondary.CampaignRepository
import org.jetbrains.exposed.sql.insert
import org.jmolecules.architecture.hexagonal.SecondaryAdapter

@SecondaryAdapter
class CampaignRepositoryPostgresAdapter : CampaignRepository {

    override suspend fun save(campaign: Campaign): Campaign {
        insert(campaign)
        return campaign
    }

    private suspend fun insert(campaign: Campaign) = coroutineDatabaseQuery {
        CampaignTable.insert {
            it[id] = campaign.id.value
            it[title] = campaign.title
        }
    }
}