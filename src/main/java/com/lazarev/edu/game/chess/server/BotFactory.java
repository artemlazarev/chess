package com.lazarev.edu.game.chess.server;

import java.io.IOException;
import java.net.Socket;

public class BotFactory {

    public static Player getNextBot() throws IOException {
        return new Player (new Socket() );
    }
}
