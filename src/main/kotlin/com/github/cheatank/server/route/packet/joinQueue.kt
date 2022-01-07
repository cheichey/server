package com.github.cheatank.server.route.packet

import com.github.cheatank.common.PacketType
import com.github.cheatank.common.data.EmptyPacketData
import com.github.cheatank.server.lobby.LobbyService
import com.github.cheatank.server.utils.sendPacket
import io.ktor.websocket.DefaultWebSocketServerSession

suspend fun DefaultWebSocketServerSession.joinQueue(lobby: LobbyService, playerId: Short) {
    lobby.joinQueue(playerId)
    sendPacket(PacketType.JoinQueue, EmptyPacketData)
}
