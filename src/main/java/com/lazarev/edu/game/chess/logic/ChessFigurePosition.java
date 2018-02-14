package com.lazarev.edu.game.chess.logic;

public class ChessFigurePosition {
    private int i;
    private int j;

    public ChessFigurePosition(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public ChessFigurePosition(){};

    public ChessFigurePosition(char[] data) {
        i = data[0] - 'a';
        j = data[1];
    }

    public String getPosition() {
        return ""+(char )('a'+ j) + (int)(i+1);
    }

    @Override
    public String toString() {
        return getPosition();
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
