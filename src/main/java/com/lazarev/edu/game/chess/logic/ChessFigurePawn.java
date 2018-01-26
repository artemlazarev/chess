package com.lazarev.edu.game.chess.logic;

public class ChessFigurePawn extends ChessFigure {
    boolean fistTurnFoFig = true;
    @Override
    public boolean checkPossibleMovement(ChessFigurePosition from, ChessFigurePosition to, BoardLayout board){
        int forward = getColor()==ChessFigureColor.WHITE? 1:-1;
        if(fistTurnFoFig)
            forward*=2;
        if (from.getJ() + forward == to.getJ())
            if( board.pathIsFree(from, to)){

            }
            return true;
        fistTurnToFig;

    };
}
