package me.lukeforit.blueprint.kmp.shared.common.session

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import me.lukeforit.blueprint.kmp.shared.common.di.SessionGraph

@SingleIn(AppScope::class)
@Inject
class SessionManager(
    private val sessionGraphFactory: SessionGraph.Factory
) {
    private val _sessionGraphFlow = MutableStateFlow<SessionGraph?>(null)
    val sessionGraphFlow: StateFlow<SessionGraph?> = _sessionGraphFlow.asStateFlow()

    fun signIn(token: String) {
        _sessionGraphFlow.value = sessionGraphFactory.create(token)
    }

    fun signOut() {
        _sessionGraphFlow.value = null
    }
}
