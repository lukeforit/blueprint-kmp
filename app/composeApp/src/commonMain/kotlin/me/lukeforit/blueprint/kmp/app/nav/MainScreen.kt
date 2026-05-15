package me.lukeforit.blueprint.kmp.app.nav

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import blueprint_kmp.shared.ui.generated.resources.Res
import blueprint_kmp.shared.ui.generated.resources.ic_dashboard
import blueprint_kmp.shared.ui.generated.resources.ic_profile
import blueprint_kmp.shared.ui.generated.resources.ic_details
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import me.lukeforit.blueprint.kmp.feature.auth.SignIn
import me.lukeforit.blueprint.kmp.feature.dashboard.DashboardScreen
import me.lukeforit.blueprint.kmp.feature.profile.ProfileScreen
import me.lukeforit.blueprint.kmp.feature.details.DetailsScreen
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalSerializationApi::class)
private val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclassesOfSealed<Route>()
        }
    }
}

@Composable
fun MainScreen() {
    val backStack = rememberNavBackStack(config, Route.SignIn)

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            item(
                icon = {
                    Icon(
                        painter = painterResource(Res.drawable.ic_dashboard),
                        contentDescription = "Dashboard"
                    )
                },
                label = { Text("Dashboard") },
                selected = true,
                onClick = { backStack.add(Route.Dashboard) }
            )
            item(
                icon = {
                    Icon(
                        painter = painterResource(Res.drawable.ic_profile),
                        contentDescription = "Profile"
                    )
                },
                label = { Text("Profile") },
                selected = false,
                onClick = { backStack.add(Route.Profile) }
            )
            item(
                icon = {Icon(
                    painter = painterResource(Res.drawable.ic_details),
                    contentDescription = "Details"
                )
                },
                label = { Text("Details") },
                selected = false,
                onClick = { backStack.add(Route.Details) }
            )
        }
    ) {
        NavDisplay(
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<Route.SignIn> { SignIn() }
                entry<Route.Dashboard> { DashboardScreen() }
                entry<Route.Profile> { ProfileScreen() }
                entry<Route.Details> { DetailsScreen() }
            }
        )
    }
}
