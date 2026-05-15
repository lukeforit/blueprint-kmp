package me.lukeforit.blueprint.kmp.plugins

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabases() {
    val driverClass = environment.config.property("storage.driverClassName").getString()
    val dbUrl = environment.config.property("storage.jdbcURL").getString()
    val dbUser = environment.config.property("storage.user").getString()
    val dbPassword = environment.config.property("storage.password").getString()

    val hikariConfig = HikariConfig().apply {
        driverClassName = driverClass
        jdbcUrl = dbUrl
        username = dbUser
        password = dbPassword
        maximumPoolSize = 10
        isAutoCommit = false
        transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        validate()
    }

    val dataSource = HikariDataSource(hikariConfig)

    // Run Flyway migrations
    Flyway.configure()
        .dataSource(dataSource)
        .load()
        .migrate()

    // Connect Exposed to the database
    Database.connect(dataSource)
    
    log.info("Database connection established and migrations run successfully.")
}
