package app.roleparty.context.flow

import app.roleparty.configuration.connectAndInitDatabase
import io.kotest.core.spec.style.BehaviorSpec
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.wait.strategy.HostPortWaitStrategy

/**
 * A [BehaviorSpec] that starts a PostgreSQL container before the spec and stops it after the spec.
 */
abstract class FlowSpec(body: BehaviorSpec.() -> Unit = {}) : BehaviorSpec(body) {

    val postgresql = PostgreSQLContainer<Nothing>("postgres:12").apply {
        // Wait for the container to be ready before running tests
        waitingFor(HostPortWaitStrategy())
    }

    init {
        beforeSpec {
            postgresql.start().run {
                // Connect to the database and initialize the schema after the container is started
                connectAndInitDatabase(
                    url = postgresql.jdbcUrl,
                    user = postgresql.username,
                    password = postgresql.password
                )
            }
        }

        afterSpec {
            postgresql.stop()
        }
    }
}

