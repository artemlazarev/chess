package com.lazarev.edu.game.chess.server;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class RoomManager {
    Room currentRoom;
    Map<String, Room> activeRooms = new HashMap<String, Room>();

    public void addNewPlayer(Socket client) throws IOException {
        Room room = getCurentRoom(client);
        System.out.println("player connected");
        if(room.playWithBot()) {
            currentRoom.addPlayer(BotFactory.getNextBot().getSoc());
            System.out.println("bot generated");
        }
        else {
            currentRoom.addPlayer(client);
            System.out.println("player connected");
        }
        if(currentRoom.full()) {
            activeRooms.put(currentRoom.getName(), currentRoom);
            System.out.println("Room full");
            System.out.println("Room try to start");
            currentRoom.start();
            System.out.println("Room started");
            currentRoom = null;
        }
    }

    public void deleteRoom(Room room){
        activeRooms.remove(room.hashCode());
    }

    private Room getCurentRoom(Socket client) throws IOException {
        if(currentRoom == null) {
            currentRoom = new Room();
        }
        else{
            ;
        }
        return currentRoom;
    }
}
