package com.github.cheatank.server.route

import com.github.cheatank.common.Packet
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.close
import io.ktor.http.cio.websocket.readBytes
import io.ktor.websocket.DefaultWebSocketServerSession

suspend fun DefaultWebSocketServerSession.connectRoute() {
    for (frame in incoming) {
        when (frame) {
            is Frame.Binary -> {
                val rawPacket = Packet.fromByteArray(frame.readBytes()) ?: return
                processPacket(rawPacket)
            }
            is Frame.Close -> {
                close()
            }
        }
    }
}
