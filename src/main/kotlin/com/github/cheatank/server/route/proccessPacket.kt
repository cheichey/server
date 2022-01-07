package com.github.cheatank.server.route

import com.github.cheatank.common.PacketType
import com.github.cheatank.common.RawPacket
import com.github.cheatank.server.lobby.LobbyService
import com.github.cheatank.server.route.packet.getVersion
import com.github.cheatank.server.route.packet.joinQueue
import io.ktor.websocket.DefaultWebSocketServerSession
import java.util.concurrent.atomic.AtomicInteger

suspend fun DefaultWebSocketServerSession.processPacket(rawPacket: RawPacket, lobbyService: LobbyService, atomicIntegerService: AtomicInteger) {
    when (rawPacket.id) {
        PacketType.GetVersion.id -> {
            getVersion()
        }
        PacketType.JoinQueue.id -> {
            joinQueue(lobbyService, atomicIntegerService.get().toShort())
        }
    }
}
