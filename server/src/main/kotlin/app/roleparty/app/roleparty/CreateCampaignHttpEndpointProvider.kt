package app.roleparty.app.roleparty

import app.roleparty.resource.createCampaign
import configure
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.createCampaign() {
    createCampaign.configure {
        call.respondText("My Campaign !")
    }
}