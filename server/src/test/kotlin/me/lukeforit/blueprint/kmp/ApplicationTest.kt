package me.lukeforit.blueprint.kmp

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import kotlin.test.*
import me.lukeforit.blueprint.kmp.shared.common.Greeting

@Testcontainers
class ApplicationTest {

    companion object {
        @JvmStatic
        @Container
        val postgres = PostgreSQLContainer<Nothing>("postgres:15-alpine").apply {
            withDatabaseName("blueprint_test")
            withUsername("postgres")
            withPassword("postgres")
        }
    }

    @Test
    fun testRoot() = testApplication {
        environment {
            config = MapApplicationConfig(
                "storage.driverClassName" to "org.postgresql.Driver",
                "storage.jdbcURL" to postgres.jdbcUrl,
                "storage.user" to postgres.username,
                "storage.password" to postgres.password
            )
        }
        application {
            module()
        }
        val response = client.get("/")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Ktor: ${Greeting().greet()}", response.bodyAsText())
    }
}