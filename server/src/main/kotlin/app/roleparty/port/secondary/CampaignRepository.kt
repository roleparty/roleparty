package app.roleparty.port.secondary

import app.roleparty.domain.Campaign

interface CampaignRepository {
    
    suspend fun save(campaign: Campaign): Campaign
}