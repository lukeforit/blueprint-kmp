package me.lukeforit.blueprint.kmp.shared.common.di

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.Qualifier
import dev.zacsweers.metro.SingleIn
import dev.zacsweers.metrox.viewmodel.ViewModelGraph
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@Qualifier
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.FIELD)
annotation class AppBackgroundScope

interface AppGraph: ViewModelGraph {
    val viewModelFactoryProvider: ViewModelFactoryProvider
    val sessionGraphFactory: SessionGraph.Factory

    @Provides
    @SingleIn(AppScope::class)
    @AppBackgroundScope
    fun provideAppBackgroundScope(): CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
}
