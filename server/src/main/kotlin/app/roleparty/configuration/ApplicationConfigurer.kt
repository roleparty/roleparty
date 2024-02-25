package app.roleparty.configuration

import io.ktor.server.application.Application

interface ApplicationConfigurer {

    context(Application)
    fun configure()
}