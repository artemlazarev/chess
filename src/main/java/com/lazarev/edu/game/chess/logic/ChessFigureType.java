package com.lazarev.edu.game.chess.logic;

public enum ChessFigureType {
    PAWN ('♙'),
    KNIGHT('♘'),
    BISHOP('♗'),
    ROOK('♖'),
    QUEEN('♕'),
    KING('♔'),
    FREE(' ');

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
