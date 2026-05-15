package me.lukeforit.blueprint.kmp.shared.common.di

import androidx.lifecycle.ViewModel
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn
import dev.zacsweers.metrox.viewmodel.ManualViewModelAssistedFactory
import dev.zacsweers.metrox.viewmodel.MetroViewModelFactory
import dev.zacsweers.metrox.viewmodel.ViewModelAssistedFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import me.lukeforit.blueprint.kmp.shared.common.session.SessionManager
import kotlin.reflect.KClass

@SingleIn(AppScope::class)
@Inject
class ViewModelFactoryProvider(
    private val sessionManager: SessionManager,
    private val appViewModelFactory: AppViewModelFactory,
    @AppBackgroundScope private val scope: CoroutineScope,
) {
    val factoryStateFlow: StateFlow<MetroViewModelFactory> =
        sessionManager.sessionGraphFlow.map { sessionGraph ->
            sessionGraph?.metroViewModelFactory ?: appViewModelFactory
        }.stateIn(
            scope = scope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = appViewModelFactory
        )
}

@Inject
@ContributesBinding(AppScope::class)
@SingleIn(AppScope::class)
class AppViewModelFactory(
    override val viewModelProviders: Map<KClass<out ViewModel>, () -> ViewModel>,
    override val assistedFactoryProviders: Map<KClass<out ViewModel>, () -> ViewModelAssistedFactory>,
    override val manualAssistedFactoryProviders: Map<KClass<out ManualViewModelAssistedFactory>, () -> ManualViewModelAssistedFactory>,
) : MetroViewModelFactory()

@Inject
@ContributesBinding(SessionScope::class)
@SingleIn(SessionScope::class)
class SessionViewModelFactory(
    override val viewModelProviders: Map<KClass<out ViewModel>, () -> ViewModel>,
    override val assistedFactoryProviders: Map<KClass<out ViewModel>, () -> ViewModelAssistedFactory>,
    override val manualAssistedFactoryProviders: Map<KClass<out ManualViewModelAssistedFactory>, () -> ManualViewModelAssistedFactory>,
) : MetroViewModelFactory()
