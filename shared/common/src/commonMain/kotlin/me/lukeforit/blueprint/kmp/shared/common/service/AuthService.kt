package me.lukeforit.blueprint.kmp.shared.common.service

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import me.lukeforit.blueprint.kmp.shared.common.di.SessionGraph

interface AuthService {
    val sessionGraphFlow: StateFlow<SessionGraph?>
    fun signIn(authToken: String)
    fun signOut()
}

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
class AuthServiceImpl @Inject constructor(
    private val sessionGraphFactory: SessionGraph.Factory
) : AuthService {

    private val _sessionGraphFlow = MutableStateFlow<SessionGraph?>(null)
    override val sessionGraphFlow = _sessionGraphFlow.asStateFlow()

    override fun signIn(authToken: String) {
        _sessionGraphFlow.value = sessionGraphFactory.create(authToken)
    }

    override fun signOut() {
        _sessionGraphFlow.value = null
    }
}
