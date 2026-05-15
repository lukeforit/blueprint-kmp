package me.lukeforit.blueprint.kmp.app.nav

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route : NavKey {
    @Serializable
    data object SignIn : Route

    @Serializable
    data object Dashboard : Route

    @Serializable
    data object Profile : Route

    @Serializable
    data object Details : Route
}
