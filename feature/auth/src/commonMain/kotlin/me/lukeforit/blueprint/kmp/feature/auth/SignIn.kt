package me.lukeforit.blueprint.kmp.feature.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.zacsweers.metrox.viewmodel.LocalMetroViewModelFactory
import dev.zacsweers.metrox.viewmodel.metroViewModel

@Composable
fun SignIn(
    viewModel: SignInViewModel = metroViewModel()
) {
    val dummyText by viewModel.dummyText.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = dummyText)
            Text("Factory: ${LocalMetroViewModelFactory.current}")
            Button(onClick = { viewModel.onSignInClick() }) {
                Text("Sign In")
            }
        }
    }
}
