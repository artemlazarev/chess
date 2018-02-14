package com.lazarev.edu.game.chess.client;

import com.lazarev.edu.game.chess.server.GameMessage;

import java.io.IOException;

public interface GameMessageProducer {
    public void sendMessage(GameMessage msg) throws IOException;
}
