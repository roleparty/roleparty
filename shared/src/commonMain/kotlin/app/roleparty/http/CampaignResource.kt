package app.roleparty.http

import kotlinx.serialization.Serializable

@Serializable
data class CampaignCreationDto(
    val title: String
)

@Serializable
data class CampaignDto(
    val id: String,
    val title: String
)