package com.github.cheatank.server.route

import com.github.cheatank.server.lobby.LobbyService
import com.github.cheatank.server.utils.readPacket
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.close
import io.ktor.websocket.DefaultWebSocketServerSession
import java.util.concurrent.atomic.AtomicInteger

suspend fun DefaultWebSocketServerSession.connectRoute(lobbyService: LobbyService) {
    for (frame in incoming) {
        when (frame) {
            is Frame.Binary ->
                (frame.readPacket())?.let {
                    processPacket(it, lobbyService, AtomicInteger())
                } ?: continue
            is Frame.Close -> close()
        }
    }
}
