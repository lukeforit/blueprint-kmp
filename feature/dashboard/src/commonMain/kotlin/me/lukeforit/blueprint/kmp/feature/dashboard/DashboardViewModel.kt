package me.lukeforit.blueprint.kmp.feature.dashboard

import androidx.lifecycle.ViewModel
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metrox.viewmodel.ViewModelKey
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.lukeforit.blueprint.kmp.shared.common.di.SessionScope

@Inject
@ViewModelKey(DashboardViewModel::class)
@ContributesIntoMap(SessionScope::class)
class DashboardViewModel: ViewModel() {
    val dummyText: StateFlow<String> = MutableStateFlow("Dashboard — dummy text from ViewModel ($this)")
}
