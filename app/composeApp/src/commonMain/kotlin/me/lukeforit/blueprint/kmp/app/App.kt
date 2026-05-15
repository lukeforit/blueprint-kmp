package me.lukeforit.blueprint.kmp.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dev.zacsweers.metrox.viewmodel.LocalMetroViewModelFactory
import me.lukeforit.blueprint.kmp.app.nav.MainScreen
import me.lukeforit.blueprint.kmp.shared.common.di.AppGraph
import me.lukeforit.blueprint.kmp.shared.ui.theme.AppTheme

@Composable
fun App(appGraph: AppGraph) {
    AppTheme {
        val activeViewModelFactory by appGraph.viewModelFactoryProvider.factoryStateFlow.collectAsState()
        CompositionLocalProvider(
            LocalMetroViewModelFactory provides activeViewModelFactory
        ) {
            MainScreen()
        }
    }
}
