package me.lukeforit.blueprint.kmp.feature.profile

import androidx.lifecycle.ViewModel
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metrox.viewmodel.ViewModelKey
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Inject
@ViewModelKey(ProfileViewModel::class)
@ContributesIntoMap(AppScope::class)
class ProfileViewModel : ViewModel() {
    val dummyText: StateFlow<String> = MutableStateFlow("Profile — dummy text from ViewModel ($this)")
}
