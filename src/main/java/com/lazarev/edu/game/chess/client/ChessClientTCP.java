package com.lazarev.edu.game.chess.client;

import com.lazarev.edu.game.chess.client.gui.MainFrameChess;
import com.lazarev.edu.game.chess.logic.BoardLayout;
import com.lazarev.edu.game.chess.server.ChessServerTCP;
import com.lazarev.edu.game.chess.server.GameMessage;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class ChessClientTCP implements GameMessageProducer, GameMessageConsumer{
    private Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private MessageSender sender;
    private ChessClientLogic clLogic;
    MainFrameChess frame;

    public ChessClientTCP(){
        initLogic();
        initTransport();
        initGUI();
    }
    private void initLogic() {
        clLogic = new ChessClientLogic();
    }

    private void initGUI() {
        MainFrameChess frame = new MainFrameChess(clLogic, sender);
    }

    public  boolean sendGameMessage(GameMessage msg){
        try{
            out.writeObject(msg);
            return true;
        }
        catch (Exception e) {
                e.printStackTrace();
                return false;
            }
    }
    private void initTransport() {
        try {
            try {
                clientSocket = new Socket("localhost", ChessServerTCP.SERVER_PORT);
            } catch (ConnectException e){
                System.out.println("No connection. Work offline.");
                return ;
            }
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
            sender = new MessageSender(out);


            Thread inputReader = new Thread(){
                public void run(){
                    BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));

                    while (true){
                        try {
                            sender.sendMessage(buffer.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            inputReader.start();


            out.writeObject(new GameMessage(GameMessage.MessageType.PLAYER_NAME, "Player".toCharArray()) );
            while(true) {
                GameMessage message = (GameMessage) in.readObject();
                System.out.println("message: " + message);
                onMessage(message);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChessClientTCP();
    }

    @Override
    public void sendMessage(GameMessage msg) throws IOException {
        sender.sendMessage(msg);
    }

    @Override
    public void onMessage(GameMessage msg) {
        ChessClientLogic logic = new ChessClientLogic();
        clLogic.onMessage(msg);
        frame.onMessage(msg);
    }

}
