package com.lazarev.edu.game.chess.server;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.net.Socket;

public class Room<T extends GameMessage >  extends Thread{
    private Player<T> p1,p2;
    private boolean play;

    private void sendMessage(Player<T> p, GameMessage msg){
        try {
            System.out.println("send: " + msg);
            p.sendData((T) msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToAll(Player<T> fromPlayer){
        try {
            System.out.println("Message to All send: " +fromPlayer.getLastMessage() );
            p2.sendData(fromPlayer.getLastInfoMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Room() throws IOException{
    }

    @Override
    public void run(){
        try{
            setGameStatus();
            while(play){
                sendMessage(p1, new GameMessage(GameMessage.MessageType.NEW_TURN, null));
                sendMessage(p2, new GameMessage(GameMessage.MessageType.NEW_TURN, null));
                System.out.println("round start");
                T gameData1 = p1.getLastMessage();
                p2.sendData(gameData1);
                T gameData2 = p2.getLastMessage();
                p1.sendData(gameData2);
                if(gameData1.getEndGame()||gameData2.getEndGame()) {
                    stopGame();
                    //deleteRoom()
                }else{
                    try {
                        sleep(50);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
            play = false;
        }
    }

    private void stopGame() {
        p1.interrupt();
        p2.interrupt();
        p1.close();
        p2.close();
    }

    private void setGameStatus() {
        p1.setOnTheGame(true);
        p2.setOnTheGame(true);
    }

    /**
     *
     * @return true if player want play thiw robot
     */
    public boolean playWithBot() {
        //TODO set by the player in? but boot not implemented.
        return false;
    }

    public void addPlayer(Socket soc) throws IOException {
        Player<T> p = new Player(soc,this);
        if(p1==null)
        {
            p1 = p;
            sendMessage(p1, new GameMessage(GameMessage.MessageType.WAITING_FOR_PLAER, null));
            return;
        }
        if(p2==null && p1!=null) {
            p2 = p;
            sendMessage(p2, new GameMessage(GameMessage.MessageType.INFO_MSG, ("Connect to player: " +p1.getName()).toCharArray()));
            sendMessage(p1, new GameMessage(GameMessage.MessageType.INFO_MSG, ("Connect to player: " +p2.getName()).toCharArray()));
        }
        else
            throw new NotImplementedException();
    }

    public boolean full(){
        return p1!=null & p2!=null;
    }

    public void close() {
        play = false;
        try {
            if(p1!=null)
                p1.getSoc().close();
            if(p2!=null)
                p2.getSoc().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
