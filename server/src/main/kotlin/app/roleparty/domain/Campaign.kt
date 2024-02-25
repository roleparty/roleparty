package app.roleparty.domain

import org.jmolecules.ddd.types.AggregateRoot
import org.jmolecules.ddd.types.Identifier
import java.util.*

private const val CAMPAIGN_NAME_MAX_LENGTH = 100

class Campaign(
    override val id: Id,
    val title: String
) : AggregateRoot<Campaign, Campaign.Id> {

    init {
        require(title.length <= CAMPAIGN_NAME_MAX_LENGTH) { "The campaign title contains ${title.length} but must not contain more than $CAMPAIGN_NAME_MAX_LENGTH characters" }
    }

    @JvmInline
    value class Id(val value: UUID) : Identifier
}