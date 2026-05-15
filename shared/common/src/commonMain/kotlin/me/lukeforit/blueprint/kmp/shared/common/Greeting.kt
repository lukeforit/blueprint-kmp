package me.lukeforit.blueprint.kmp.shared.common

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}
