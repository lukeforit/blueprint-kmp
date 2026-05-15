package me.lukeforit.blueprint.kmp.feature.details

import androidx.lifecycle.ViewModel
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metrox.viewmodel.ViewModelKey
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Inject
@ViewModelKey(DetailsViewModel::class)
@ContributesIntoMap(AppScope::class)
class DetailsViewModel : ViewModel() {
    val dummyText: StateFlow<String> = MutableStateFlow("Details — dummy text from ViewModel ($this)")
}
