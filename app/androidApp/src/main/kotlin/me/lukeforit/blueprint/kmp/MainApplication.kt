package me.lukeforit.blueprint.kmp

import android.app.Application
import dev.zacsweers.metro.createGraphFactory
import dev.zacsweers.metrox.android.MetroAppComponentProviders
import dev.zacsweers.metrox.android.MetroApplication
import me.lukeforit.blueprint.kmp.shared.common.di.AndroidAppGraph

class MainApplication : Application(), MetroApplication {
    
    private val appGraph: AndroidAppGraph by lazy {
        createGraphFactory<AndroidAppGraph.Factory>()
            .create(this)
    }

    override fun onCreate() {
        super.onCreate()
    }

    override val appComponentProviders: MetroAppComponentProviders
        get() = appGraph
}
