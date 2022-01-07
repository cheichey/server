package com.github.cheatank.server.lobby

import java.util.concurrent.ConcurrentLinkedQueue

data class QueueImpl(
    override val queue: ConcurrentLinkedQueue<Short>
) : Queue {
    override fun add(id: Short): Boolean {
        return queue.add(id)
    }
}
