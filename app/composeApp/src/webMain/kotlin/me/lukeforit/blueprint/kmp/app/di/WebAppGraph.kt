package me.lukeforit.blueprint.kmp.app.di

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import me.lukeforit.blueprint.kmp.shared.common.di.AppGraph

@DependencyGraph(AppScope::class)
interface WebAppGraph : AppGraph
