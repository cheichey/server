package com.github.cheatank.server.lobby

import java.util.concurrent.ConcurrentLinkedQueue

interface Queue {
    val queue: ConcurrentLinkedQueue<Short>

    /**
     * キューにプレイヤーを追加する
     * @param id プレイヤーの id
     * @return 追加できたら true 追加できなければ false
     */
    fun add(id: Short): Boolean
}
