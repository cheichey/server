package com.github.cheatank.server.route

import com.github.cheatank.server.lobby.LobbyService
import io.ktor.routing.Routing
import io.ktor.websocket.webSocket
import org.koin.ktor.ext.inject

/**
 * ルーティングの設定
 */
fun Routing.route() {

    val lobbyService: LobbyService by inject()

    webSocket("/") {
        connectRoute(lobbyService)
    }
}
