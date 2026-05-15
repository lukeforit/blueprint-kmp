package me.lukeforit.blueprint.kmp.shared.common.di

import dev.zacsweers.metro.GraphExtension
import dev.zacsweers.metro.Provides
import dev.zacsweers.metrox.viewmodel.ViewModelGraph

@GraphExtension(SessionScope::class)
interface SessionGraph : ViewModelGraph {

    @GraphExtension.Factory
    interface Factory {
        fun create(@Provides authToken: String): SessionGraph
    }
}
