package com.lazarev.edu.game.chess.logic;

public class ChessFigureBishop extends ChessFigure {
    private boolean fistTurnFoFig = true;
    public ChessFigureBishop(ChessFigureColor color){
        super(color, ChessFigureType.BISHOP );
    }

    public boolean checkPossibleMovementByType(ChessFigurePosition from, ChessFigurePosition to, BoardLayout board){
        int i = Math.abs(from.getI()-to.getI());
        int j = Math.abs(from.getJ()-to.getJ());
        if ( i==j )
                return board.pathIsFree(from, to );
            else
                return false;
    };
}
