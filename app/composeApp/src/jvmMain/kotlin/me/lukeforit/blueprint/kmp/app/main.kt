package me.lukeforit.blueprint.kmp.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.zacsweers.metro.createGraph
import me.lukeforit.blueprint.kmp.app.di.JvmAppGraph

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "app-aint-about-money",
    ) {
        val appGraph = createGraph<JvmAppGraph>()
        App(appGraph = appGraph)
    }
}