package com.lazarev.edu.game.chess.logic;

public class BoardLayout {
    private ChessFigure[][] boardChess;

    private BoardLayout(){
        boardChess = InitLayout.boardChess.clone();
    }
    public boolean setFigAtPosition(ChessFigurePosition pos, ChessFigure fig){
        boardChess[pos.getI()][pos.getJ()] = fig;
        return true;
    }
    public static BoardLayout getBoardLayout(){
        return new BoardLayout();
    }
}
