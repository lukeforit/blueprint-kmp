package me.lukeforit.blueprint.kmp.app

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import dev.zacsweers.metro.createGraph
import me.lukeforit.blueprint.kmp.app.di.WebAppGraph

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        val appGraph = createGraph<WebAppGraph>()
        App(appGraph = appGraph)
    }
}