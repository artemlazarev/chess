package com.lazarev.edu.game.chess.logic;

public class ChessFigurePawn extends ChessFigure {
    public ChessFigurePawn(ChessFigureColor color){
        super(color, ChessFigureType.PAWN );
    }

    public boolean checkPossibleMovementByType(ChessFigurePosition from, ChessFigurePosition to, BoardLayout board){
        //the direction
        int forward = getColor()==ChessFigureColor.WHITE? 1:-1;
        //check for capturing
        if (from.getI() == to.getI()-1 || from.getI() == to.getI()+1  ) {
            if (from.getJ()+forward == to.getJ())
                if (board.getFigAtPosition(to).getType() != ChessFigureType.FREE)
                    return true;
                else
                    return false;
            //TODO check for En passant
        }
        //first turn for fig = movment*2

        if( Math.abs(from.getI()-to.getI()) == 1)
            if(board.getFigAtPosition(to).getType() == ChessFigureType.FREE)
                return true;
            else;
        else
            if( Math.abs(from.getI()-to.getI()) == 2)
                return  board.getFigAtPosition(from.getI()+forward, from.getJ()).getType() == ChessFigureType.FREE
                        && board.getFigAtPosition(to).getType() == ChessFigureType.FREE;
            else
                return false;

        return false;
    };
}
