package com.github.cheatank.server.lobby

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LobbyServiceImpl : LobbyService, KoinComponent {
    override val queue: Queue by inject()

    override suspend fun joinQueue(id: Short): Boolean {
        return queue.add(id)
    }
}
