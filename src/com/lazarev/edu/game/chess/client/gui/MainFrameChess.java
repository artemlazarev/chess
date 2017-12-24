package com.lazarev.edu.game.chess.client.gui;

import com.lazarev.edu.game.chess.client.gui.ChessFigureGUI;
import com.lazarev.edu.game.chess.logic.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MainFrameChess {

    private JFrame frame;
    private JLabel messageLabel;
    private BoardLayout boardLayout = BoardLayout.getBoardLayout();
    ChessFigurePosition curentPlayedPos;
    ChessFigure curentChessFigure;
    int f_lengh = InitLayout.F_LENGH;
    Square[][] board = new Square[f_lengh][f_lengh];


    public MainFrameChess(){
        curentPlayedPos = new ChessFigurePosition();
        curentChessFigure = new ChessFigure();
        frame = new JFrame("Chess");
        messageLabel = new JLabel("no text");
        messageLabel.setBackground(Color.lightGray);
        frame.getContentPane().add(messageLabel, BorderLayout.SOUTH);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(f_lengh, f_lengh));
        for (int i = 0; i < InitLayout.F_LENGH; i++) {
            for (int j = 0; j < InitLayout.F_LENGH; j++) {
                board[i][j] = new Square(i,j);
                board[i][j].initSquare();
                board[i][j].addMouseListener(new SquareMouseListener(board[i][j]));
                boardPanel.add(board[i][j], i,j);
            }
        }
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
        for (int i = 0; i < InitLayout.F_LENGH; i++) {
            for (int j = 0; j < InitLayout.F_LENGH; j++) {
                board[i][j].setText(String.valueOf( InitLayout.board[i][j] ));
            }
        }
    };

    private class Square extends JPanel {
        private final static int SQUARE_W = 50;
        private final static int SQUARE_H = SQUARE_W;
        ChessFigureGUI fig;
        ChessFigurePosition pos;
        JLabel label = new JLabel((Icon) null);
        Color color;

        private Square(Color color) {
            this.color = color;
            setPreferredSize(new Dimension(SQUARE_W, SQUARE_H));
            label.setFont(new Font("Serif", Font.BOLD, SQUARE_W-20));
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

        public void setText(String t) {
            label.setText(t);
        }

        public void setChessFigureGUI(ChessFigureGUI f){
            fig = f;
            board[pos.getI()][pos.getJ()].setText(String.valueOf( fig.getText() ));
        }

        public void initSquare(){
            ChessFigureGUI f = new ChessFigureGUI ( InitLayout.boardChess[pos.getI()][pos.getJ()] );
            setChessFigureGUI(f);
        }
        public String getInfo() {
            return pos.getPosition() + " "+ fig.toString();
        }

        public void pressed() {
            if (curentChessFigure.getFigureTouched())
            {
                curentChessFigure.setFigureTouched(false);
                setBorder(BorderFactory.createLineBorder(color,2));
                if(fig.checkPossibleMovement(curentPlayedPos, pos))
                    boardLayout.setFigAtPosition(pos, curentChessFigure);
            }
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
