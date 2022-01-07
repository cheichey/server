package com.github.cheatank.server

import com.github.cheatank.server.route.route
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.http.cio.websocket.pingPeriod
import io.ktor.http.cio.websocket.timeout
import io.ktor.routing.routing
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.ktor.websocket.WebSockets
import org.koin.core.annotation.KoinReflectAPI
import org.koin.core.module.Module
import org.koin.ktor.ext.Koin
import java.time.Duration

/**
 * サーバーを起動する
 */
fun startServer() {
    embeddedServer(CIO, port = 8080, module = Application::application).start(true)
}

/**
 * サーバーの設定をする
 */
@Suppress("EXPERIMENTAL_IS_NOT_ENABLED")
@OptIn(KoinReflectAPI::class)
fun Application.application(testing: Boolean = false, testModule: Module? = null) {
    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }
    install(Koin) {
        modules(modules)
        if (testing && testModule != null) {
            modules(testModule)
        }
    }

    routing {
        route()
    }
}
