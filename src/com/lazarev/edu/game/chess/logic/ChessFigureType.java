package com.lazarev.edu.game.chess.logic;

public enum ChessFigureType {
    PAWN (InitLayout.board[1][1]),
    KNIGHT(InitLayout.board[0][2]),
    BISHOP(InitLayout.board[0][3]),
    ROOK(InitLayout.board[0][0]),
    QUEEN(InitLayout.board[0][4]),
    KING(InitLayout.board[0][5]);

    private final String name;

    private ChessFigureType(String s) {
        name = s;
    }
    private ChessFigureType(char s) {
        name = String.valueOf(s) ;
    }
    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}
