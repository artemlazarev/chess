package com.lazarev.edu.game.chess.logic;

public class ChessFigureKing extends ChessFigure {
    private boolean fistTurnFoFig = true;
    public ChessFigureKing(ChessFigureColor color){
        super(color, ChessFigureType.KING );
    }

    public boolean checkPossibleMovementByType(ChessFigurePosition from, ChessFigurePosition to, BoardLayout board){
        int i = Math.abs(from.getI()-to.getI());
        int j = Math.abs(from.getJ()-to.getJ());
        if(i>1 || j>1)
            return false;
        if ( i==j )
            return true;
        else {
            if ( (i==0 && j !=0 )  || (j==0 && i!=0) )
                return true;
            else
                return false;
        }
    };
}
