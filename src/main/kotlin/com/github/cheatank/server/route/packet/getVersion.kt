package com.github.cheatank.server.route.packet

import com.github.cheatank.common.Packet
import com.github.cheatank.common.PacketType
import com.github.cheatank.common.PacketVersion
import com.github.cheatank.common.data.IntData
import io.ktor.http.cio.websocket.Frame
import io.ktor.websocket.DefaultWebSocketServerSession

suspend fun DefaultWebSocketServerSession.getVersion() {
    val packetType = PacketType.SendVersion
    val bytes = Packet.toByteArray(packetType, IntData(PacketVersion))
    send(Frame.Binary(true, bytes))
}
