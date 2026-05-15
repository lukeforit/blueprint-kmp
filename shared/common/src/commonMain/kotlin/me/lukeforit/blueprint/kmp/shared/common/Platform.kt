package me.lukeforit.blueprint.kmp.shared.common

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
