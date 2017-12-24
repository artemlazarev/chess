package com.lazarev.edu.game.chess.logic;

public class ChessFigurePosition {
    int i;
    int j;

    public ChessFigurePosition(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public ChessFigurePosition(){};
    public String getPosition() {
        return " "+(char )('a'+ j) + (int)(i+1);
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
