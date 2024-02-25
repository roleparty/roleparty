package app.roleparty.adapter.secondary

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

suspend fun <T> coroutineDatabaseQuery(query: suspend () -> T): T = newSuspendedTransaction(Dispatchers.IO) { query() }