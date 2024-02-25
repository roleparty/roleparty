package app.roleparty.flow

import app.roleparty.adapter.secondary.coroutineDatabaseQuery
import app.roleparty.configuration.CampaignTable
import app.roleparty.http.CampaignCreationDto
import app.roleparty.http.CampaignDto
import app.roleparty.context.flow.FlowSpec
import app.roleparty.context.flow.testConfiguredApplication
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.matchers.shouldBe
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import java.util.UUID
import org.jetbrains.exposed.sql.selectAll


class CampaignCreationFlowTest : FlowSpec({

    given("a user") {
        `when`("the user creates a campaign") {
            then("the campaign is created") {
                testConfiguredApplication { configuredClient ->
                    val response = configuredClient.post("/campaigns") {
                        header(HttpHeaders.ContentType, ContentType.Application.Json)
                        setBody(CampaignCreationDto("Test"))
                    }

                    val responseBody = response.body<CampaignDto>()
                    shouldNotThrowAny { UUID.fromString(responseBody.id) }
                    responseBody.title shouldBe "Test"

                    coroutineDatabaseQuery {
                        CampaignTable.selectAll().single().let {
                            it[CampaignTable.id].toString() shouldBe responseBody.id
                            it[CampaignTable.title] shouldBe "Test"
                        }
                    }
                }
            }
        }
    }

})