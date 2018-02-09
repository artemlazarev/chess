package com.lazarev.edu.game.chess.logic;

public class ChessFigureNo extends ChessFigure {
    @Override
    public boolean checkPossibleMovementByType(ChessFigurePosition from, ChessFigurePosition to, BoardLayout board) {
        return false;
    }
}
