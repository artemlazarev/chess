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
    public ChessFigure getFigAtPosition(ChessFigurePosition pos)
    {
        return boardChess[pos.getI()][pos.getJ()];
    }
    public ChessFigure getFigAtPosition(int i, int j)
    {
        return boardChess[i][j];
    }
    public static BoardLayout getBoardLayout(){
        return new BoardLayout();
    }

    public boolean pathIsFree(ChessFigurePosition from, ChessFigurePosition to) {
        //check for out of the board
        if(from.getJ()<0 || from.getJ()<0|| to.getI()> InitLayout.F_LENGH-1  || to.getJ()> InitLayout.F_LENGH -1 )
            return false;
        //check vertical line
        if(from.getJ()==to.getJ()) {
            for (int i = from.getI(); i < to.getI(); i++) {
                if (positionBusy(boardChess[i][from.getJ()]))
                    return false;
            }
            return true;
        }
        //check horisontal line
        if(from.getI()==to.getI()){
            for( int i=from.getJ(); i<to.getJ(); i++ ){
                if(positionBusy(boardChess[from.getI()][i] ))
                    return false;
            }
            return true;
        }
        //check oblique line
        int stepcount = to.getI() - from.getI();
        for( int i=0; i<stepcount; i++ ){
            if( positionBusy(boardChess[from.getI()+i][from.getJ()+i]))
                return false;
        }
        return true;
    }
    public boolean positionBusy( ChessFigure fig){
        return (fig.getType() != ChessFigureType.FREE);
    }
}
