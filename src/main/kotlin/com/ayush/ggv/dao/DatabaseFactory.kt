package com.ayush.ggv.dao


import com.ayush.ggv.dao.auth.UserTable
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import java.net.URI

object DatabaseFactory {
    fun init(){
        Database.connect(createHikariDataSource())
        transaction {
            SchemaUtils.create(
                UserTable,
            )
        }
    }

    private fun createHikariDataSource(): HikariDataSource {
        val driverClass = "org.postgresql.Driver"
        val databaseUri = URI(System.getenv("ggv_counselling_db"))

        val port = if (databaseUri.port != -1) databaseUri.port else 5432
        val jdbcUrl = "jdbc:postgresql://" + databaseUri.host + ':' + port + databaseUri.path
        println("JDBC URL: $jdbcUrl")
        val userInfo = databaseUri.userInfo.split(":")
        val username = userInfo[0]
        val password = userInfo[1]

        val hikariConfig = HikariConfig().apply {
            driverClassName = driverClass
            setJdbcUrl(jdbcUrl)
            this.username = username
            this.password = password
            maximumPoolSize = 3
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        }

        return HikariDataSource(hikariConfig)
    }

    //Generic Function to handle db transactions
    suspend fun <T> dbQuery(block: suspend () -> T) =
        newSuspendedTransaction(Dispatchers.IO) { block()  }
}