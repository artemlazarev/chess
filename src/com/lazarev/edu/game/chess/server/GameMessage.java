package com.lazarev.edu.game.chess.server;

import java.io.Serializable;

public class GameMessage implements Serializable {
    public enum MessageType{
        END_GAME,
        PLAYER_NAME,
        NEW_TURN,
        WAITING_FOR_PLAER,
        BOT_TYPE,
        INFO_MSG,
        TURN_DATA,
    }

    char [] data;
    MessageType type;


    public GameMessage(MessageType type, char [] data){
        this.type = type;
        this.data = data;
    }
    public boolean getEndGame() {
        return type == MessageType.END_GAME;
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        if(data == null)
            return getType() + ", null" ;
        else {
            StringBuilder sb = new StringBuilder();
            return getType() + ", " + sb.append(getData());
        }
    }
}
