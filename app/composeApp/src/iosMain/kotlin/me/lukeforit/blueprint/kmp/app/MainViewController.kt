package me.lukeforit.blueprint.kmp.app

import androidx.compose.ui.window.ComposeUIViewController
import dev.zacsweers.metro.createGraph
import me.lukeforit.blueprint.kmp.app.di.IosAppGraph

fun MainViewController() = ComposeUIViewController { 
    val appGraph = createGraph<IosAppGraph>()
    App(appGraph = appGraph) 
}