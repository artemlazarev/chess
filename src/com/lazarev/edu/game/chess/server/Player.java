package com.lazarev.edu.game.chess.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Player<T extends GameMessage > extends Thread{
    protected Socket soc;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private T lastMessage;
    private T lastInfoMessage;
    private Boolean playerTurn = false;
    private Boolean onTheGame;
    private Room playerCurentRoom;

    public <T extends GameMessage> Player(Socket soc, Room<T> tRoom) throws IOException {
        this(soc);
        playerCurentRoom = tRoom;
    }

    public Boolean getOnTheGame() {
        return onTheGame;
    }

    public void setOnTheGame(Boolean onTheGame) {
        this.onTheGame = onTheGame;
    }

    public Boolean getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(Boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Socket getSoc() {
        return soc;
    }

    public void setSoc(Socket soc) {
        this.soc = soc;
        onTheGame=true;
    }

    public Player(Socket client) throws IOException {
        soc = client;
        in = new ObjectInputStream(soc.getInputStream());
        out = new ObjectOutputStream(soc.getOutputStream());
        onTheGame=true;
        start();
    }
    @Override
    public void run(){
        try {
            while (true) {
                T message = (T) in.readObject();
                System.out.println( message.toString());
                if(playerTurn)
                    lastMessage = message;
                if(message.type == GameMessage.MessageType.INFO_MSG){
                    lastInfoMessage = message;
                    if (playerCurentRoom!=null)
                        playerCurentRoom.sendMessageToAll(this);
                }

                try {
                    sleep(50);
                } catch (InterruptedException e) {
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e1){
            e1.printStackTrace();
        }
        finally {
            close();
        }
    }
    public void close(){
        onTheGame=false;
        try {
            in.close();
            out.close();
            soc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T getLastMessage() {
        return lastMessage;
    }

    public void sendData(T gameData) throws IOException {
        out.writeObject(gameData);
    }

    public T getLastInfoMessage() {
        return lastInfoMessage;
    }

    public void setLastInfoMessage(T lastInfoMessage) {
        this.lastInfoMessage = lastInfoMessage;
    }
}
