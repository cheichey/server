import com.github.cheatank.common.Packet
import com.github.cheatank.common.PacketType
import com.github.cheatank.common.PacketVersion
import com.github.cheatank.common.data.EmptyPacketData
import com.github.cheatank.common.data.IntData
import com.github.cheatank.server.route.connectRoute
import io.ktor.application.install
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.readBytes
import io.ktor.routing.routing
import io.ktor.server.testing.withTestApplication
import io.ktor.websocket.WebSockets
import io.ktor.websocket.webSocket
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

class WebSocketTest {
    @Test
    fun getVersionTest() {
        withTestApplication {
            application.install(WebSockets)
            application.routing {
                webSocket("/") {
                    connectRoute()
                }
            }
            handleWebSocketConversation("/") {
                incoming, outgoing ->
                val bytes = Packet.toByteArray(PacketType.GetVersion, EmptyPacketData)
                outgoing.send(Frame.Binary(true, bytes))
                val rawPacket = Packet.fromByteArray(incoming.receive().readBytes())
                assertNotNull(rawPacket)
                val packet = rawPacket.toPacket(PacketType.SendVersion)
                assertNotNull(packet)
                val packetData = packet.data
                assertIs<IntData>(packetData)
                assertEquals(packetData.int, PacketVersion)
                outgoing.close()
            }
        }
    }
}
