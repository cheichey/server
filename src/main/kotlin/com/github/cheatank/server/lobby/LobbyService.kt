package com.github.cheatank.server.lobby

interface LobbyService {
    /**
     * 待ち行列
     */
    val queue: Queue

    /**
     * キューに参加する
     * @param id プレイヤーの id
     * @return キューに入れたら true 入れなかったら false
     */
    suspend fun joinQueue(id: Short): Boolean
}
