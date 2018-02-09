package com.lazarev.edu.game.chess.logic;

public class ChessFigureKnight extends ChessFigure {
    private boolean fistTurnFoFig = true;
    public ChessFigureKnight(ChessFigureColor color){
        super(color, ChessFigureType.KNIGHT );
    }

    public boolean checkPossibleMovementByType(ChessFigurePosition from, ChessFigurePosition to, BoardLayout board){
        int j = Math.abs(from.getJ()-to.getJ());
        int i = Math.abs(from.getI()-to.getI());
        if (( i==2 & j==1)  || (j==2 & i==1))
            return true;
        else
            return false;
    };
}
