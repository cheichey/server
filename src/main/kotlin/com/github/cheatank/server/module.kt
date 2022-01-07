package com.github.cheatank.server

import com.github.cheatank.server.lobby.LobbyService
import com.github.cheatank.server.lobby.LobbyServiceImpl
import com.github.cheatank.server.lobby.Queue
import com.github.cheatank.server.lobby.QueueImpl
import org.koin.core.annotation.KoinReflectAPI
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.dsl.single
import java.util.concurrent.ConcurrentLinkedQueue

@KoinReflectAPI
val modules = module {
    single<LobbyServiceImpl>() bind LobbyService::class
    factory<Queue> { QueueImpl(ConcurrentLinkedQueue()) }
}
