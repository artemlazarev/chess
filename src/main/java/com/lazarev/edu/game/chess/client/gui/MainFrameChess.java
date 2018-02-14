package com.lazarev.edu.game.chess.client.gui;

import com.lazarev.edu.game.chess.client.ChessClientLogic;
import com.lazarev.edu.game.chess.client.GameMessageConsumer;
import com.lazarev.edu.game.chess.client.GameMessageProducer;
import com.lazarev.edu.game.chess.client.MessageSender;
import com.lazarev.edu.game.chess.logic.*;
import com.lazarev.edu.game.chess.server.GameMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

//https://stackoverflow.com/questions/21142686/making-a-robust-resizable-swing-chess-gui

public class MainFrameChess implements GameMessageProducer, GameMessageConsumer {

    private JFrame frame;
    private JLabel messageLabel;
    private ChessClientLogic clientLogic;
    ChessFigurePosition curentPlayedPos;
    //ChessFigure curentChessFigure;
    private BoardLayout boardLayout;
    MessageSender sender;
    int fLn;
    Square[][] board;

    public MainFrameChess(ChessClientLogic clientLogic, MessageSender sender){
        this.sender = sender;
        this.clientLogic = clientLogic;
        this.boardLayout= clientLogic.getBoardLayout();
        fLn = boardLayout.getBoardLengh();
        board = new Square[fLn][fLn];
        curentPlayedPos = new ChessFigurePosition();
        frame = new JFrame("Chess");
        messageLabel = new JLabel("no text");
        messageLabel.setBackground(Color.lightGray);
        frame.getContentPane().add(messageLabel, BorderLayout.SOUTH);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(fLn+1, fLn+1));
        for (int i = 0; i < fLn; i++) {
            for (int j = 0 ; j < fLn; j++) {
                //if(j!=0){
                    board[i][j] = new Square(i,j);
                    board[i][j].addMouseListener(new SquareMouseListener(board[i][j]));
                    boardPanel.add(board[i][j]);
                //}
            }
            boardPanel.add( new JLabel( ""+i, SwingConstants.CENTER));
        }

        for (int i = 0; i < 8; i++) {
            boardPanel.add( new JLabel( ""+(char )('a'+ i), SwingConstants.CENTER),8,i);
            //boardPanel.add( new JLabel( ""+i, SwingConstants.CENTER),i,8);
        }
        boardPanel.add( new JLabel( "", SwingConstants.CENTER),8,8);

        frame.getContentPane().add(boardPanel, BorderLayout.CENTER);
        frame.getContentPane().add(boardPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();

        frame.setLocation((1520 ) - (frame.getWidth() / 2),
                (1080 / 2) - (frame.getHeight() / 2));

        frame.setVisible(true);
        initFigureLayout();
    }

    public void initFigureLayout(){
        for (int i = 0; i < fLn; i++) {
            for (int j = 0; j < fLn; j++) {
                board[i][j].initSquare( boardLayout.getFigAtPosition(i,j));

            }
        }
    };

    @Override
    public void sendMessage(GameMessage msg) throws IOException {
        sender.sendMessage(msg);
    }
    public void onMessage(GameMessage msg){
        if(msg.getType() == GameMessage.MessageType.TURN_DATA) {
            int i = msg.getData()[0];
            int j = msg.getData()[1];
            board[i][j].pressed();
        }
    };

    private class Square extends JPanel {
        private final static int SQUARE_W = 50;
        private final static int SQUARE_H = SQUARE_W;
        ChessFigure fig;
        ChessFigurePosition pos;
        JLabel label = new JLabel();
        Color color;

        private Square(Color color) {
            this.color = color;
            setPreferredSize(new Dimension(SQUARE_W, SQUARE_H));
            label.setFont(new Font("Serif", Font.BOLD, SQUARE_W-10));
            setBackground(color);
            setLayout(new BorderLayout());
            add(label, BorderLayout.CENTER);
        }

        public Square(int i, int j) {
            this( InitLayout.getSquaresColor(i,j)==ChessFigureColor.BLACK? Color.GRAY: Color.WHITE);
            pos = new ChessFigurePosition(i,j);
        }

        public void setIcon(ImageIcon icon) {
            Image image = icon.getImage(); // transform it
            Image newimg = image.getScaledInstance(SQUARE_W, SQUARE_H,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            label.setIcon(new ImageIcon(newimg));
        }

        public void setChessFigure(ChessFigure f){
            fig = f;
            label.setText(f.toString());
        }

        /*public void initSquare(){
            setChessFigure(new ChessFigureNo());
        }*/
        public void initSquare(ChessFigure f){
            setChessFigure(f);
        }

        public String getInfo() {
            return pos.getPosition() + " "+ fig.toString();
        }

        public void pressed() {
            pos
            if(clientLogic.onMessage(pos))
                setChessFigure(curentChessFigure);
            /*
            if(curentChessFigure==null)
                curentChessFigure = fig;
            if (curentChessFigure.getFigureTouched())
            {
                if(curentChessFigure.equals(fig)) {
                    curentChessFigure.setFigureTouched(false);
                    setBorder(BorderFactory.createLineBorder(color, 2));
                }
                if(curentChessFigure.checkPossibleMovement(curentPlayedPos, pos, boardLayout)) {
                    boardLayout.setFigAtPosition(pos, curentChessFigure);
                    boardLayout.setFigAtPosition(curentPlayedPos, new ChessFigureNo ());
                    board[curentPlayedPos.getI()][curentPlayedPos.getJ()].setChessFigure(new ChessFigureNo());
                    setChessFigure(curentChessFigure);
                    board[curentPlayedPos.getI()][curentPlayedPos.getJ()].setBorder(BorderFactory.createLineBorder(color, 2));
                    curentChessFigure=null;
                }
                else ;

            }*/
            else {
                setBorder(BorderFactory.createLineBorder(Color.yellow,2));
                curentPlayedPos = pos;
                fig.setFigureTouched(true);
                curentChessFigure = fig;
            }
        }
    }

    class SquareMouseListener  extends MouseAdapter{
        Square currentSquare;
        SquareMouseListener(Square sq){
            currentSquare = sq;
        }
        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("Pressed " + currentSquare.getInfo());
            currentSquare.pressed();

        }
    }
}
