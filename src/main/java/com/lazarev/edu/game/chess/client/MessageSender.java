package com.lazarev.edu.game.chess.client;

import com.lazarev.edu.game.chess.server.GameMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class MessageSender implements GameMessageProducer{
    ObjectOutputStream out;
    public MessageSender(ObjectOutputStream out){
        this.out = out;
        //start();
    }
    public void sendMessage(GameMessage msg) throws IOException {
        out.writeObject(msg);
    }
    public void sendMessage(String msg) throws IOException {
        out.writeObject(new GameMessage(GameMessage.MessageType.INFO_MSG, msg.toCharArray()) );
    }

}
