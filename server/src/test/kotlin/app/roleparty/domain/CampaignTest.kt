package app.roleparty.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException
import java.util.*

class CampaignTest : ShouldSpec({
    
    context("when campaign construct") {
        context("when campaign name contains more than 100 characters") {
            should("throw illegal argument exception") {
                val name = "a".repeat(101)
                
                val exception = shouldThrow<IllegalArgumentException> {
                    Campaign(Campaign.Id(UUID.randomUUID()), name)
                }
                
                exception.message shouldBe "The campaign title contains 101 but must not contain more than 100 characters"
            }
        }
    }
})