package me.lukeforit.blueprint.kmp

import io.ktor.server.application.*
import me.lukeforit.blueprint.kmp.plugins.configureDatabases
import me.lukeforit.blueprint.kmp.shared.common.Greeting
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureDatabases()
    
    routing {
        get("/") {
            call.respondText("Ktor: ${Greeting().greet()}")
        }
    }
}