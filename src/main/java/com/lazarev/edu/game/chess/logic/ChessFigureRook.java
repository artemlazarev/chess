package com.lazarev.edu.game.chess.logic;

public class ChessFigureRook extends ChessFigure {
    private boolean fistTurnFoFig = true;
    public ChessFigureRook(ChessFigureColor color){
        super(color, ChessFigureType.ROOK );
    }

    public boolean checkPossibleMovementByType(ChessFigurePosition from, ChessFigurePosition to, BoardLayout board){
        int j = Math.abs(from.getJ()-to.getJ());
        int i = Math.abs(from.getI()-to.getI());
        if ( (i==0 && j !=0 )  || (j==0 && i!=0) )
            return board.pathIsFree(from, to );
        else
            return false;
    };
}
