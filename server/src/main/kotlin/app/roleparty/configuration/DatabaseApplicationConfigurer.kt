package app.roleparty.configuration

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseApplicationConfigurer : ApplicationConfigurer {
    override fun configure() {
        connectAndInitDatabase(
            url = "jdbc:postgresql://localhost:5433/roleparty",
            user = "postgres",
            password = "postgres"
        )
    }
}

private val TABLES = arrayOf(
    CampaignTable
)

fun connectAndInitDatabase(url: String, user: String, password: String, vararg tables: Table = TABLES) {
    val database = Database.connect(
        url = url,
        user = user,
        password = password
    )
    transaction(database) {
        SchemaUtils.createMissingTablesAndColumns(
            tables = tables
        )
    }
}

object CampaignTable : Table() {
    val id = uuid("id")
    val title = varchar("title", 100)

    override val primaryKey = PrimaryKey(id)
}