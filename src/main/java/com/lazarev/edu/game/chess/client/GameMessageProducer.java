package com.lazarev.edu.game.chess.client;

import com.lazarev.edu.game.chess.server.GameMessage;

public interface GameMessageProducer {
    public void onMessage(GameMessage msg);
}
