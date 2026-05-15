package me.lukeforit.blueprint.kmp.di

import android.app.Application
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Provides
import dev.zacsweers.metrox.android.MetroAppComponentProviders
import me.lukeforit.blueprint.kmp.shared.common.di.AppGraph

@DependencyGraph(AppScope::class)
interface AndroidAppGraph : MetroAppComponentProviders, AppGraph {

    @DependencyGraph.Factory
    interface Factory {
        fun create(@Provides application: Application): AndroidAppGraph
    }
}
