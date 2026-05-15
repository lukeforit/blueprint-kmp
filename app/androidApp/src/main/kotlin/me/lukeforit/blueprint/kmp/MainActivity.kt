package me.lukeforit.blueprint.kmp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.binding
import dev.zacsweers.metrox.android.ActivityKey
import me.lukeforit.blueprint.kmp.app.App
import me.lukeforit.blueprint.kmp.di.AndroidAppGraph

@android.annotation.SuppressLint("Instantiatable")
@ActivityKey(MainActivity::class)
@ContributesIntoMap(AppScope::class, binding = binding<Activity>())
class MainActivity(
    private val appGraph: AndroidAppGraph
) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            App(appGraph = appGraph)
        }
    }
}
