package com.lazarev.edu.game.chess.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChessServerTCP {
    ServerSocket server;
    public static int SERVER_PORT = 9090;
    private RoomManager playerConnector;
    private boolean work=true;
    public ChessServerTCP(){
        playerConnector = new RoomManager();
        try {
            server = new ServerSocket(SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        while(work){
            try {
                System.out.println("Waiting for connection");
                Socket client =  server.accept();
                playerConnector.addNewPlayer(client);
            } catch (IOException e) {
                e.printStackTrace();
                work = false;
            }
        }
    }

    public static void main(String[] args) {
        new ChessServerTCP();
    }
    public void deleteRoom(Room room){
        playerConnector.deleteRoom(room);
    }

}
