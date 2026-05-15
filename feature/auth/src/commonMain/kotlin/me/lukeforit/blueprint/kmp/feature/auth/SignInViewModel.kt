package me.lukeforit.blueprint.kmp.feature.auth

import androidx.lifecycle.ViewModel
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metrox.viewmodel.ViewModelKey
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.lukeforit.blueprint.kmp.shared.common.service.AuthService
import me.lukeforit.blueprint.kmp.shared.common.session.SessionManager

@Inject
@ViewModelKey(SignInViewModel::class)
@ContributesIntoMap(AppScope::class)
class SignInViewModel(
    private val authService: AuthService,
    private val sessionManager: SessionManager,
) : ViewModel() {
    val dummyText: StateFlow<String> = MutableStateFlow("Sign In — dummy text from ViewModel ($this)")

    fun onSignInClick(authToken: String = "dummy-token") {
        authService.signIn(authToken)
        sessionManager.signIn(authToken)
    }
}
