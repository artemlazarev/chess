package com.lazarev.edu.game.chess.logic;


public class ChessFigure {
    private ChessFigureColor color;
    private ChessFigureType type;
    private char text;
    private boolean figureTouched;

    public Boolean getFigureTouched() {
        return figureTouched;
    }

    public void setFigureTouched(boolean figureTouched) {
        this.figureTouched = figureTouched;
    }
    public ChessFigure (ChessFigureColor color, ChessFigureType type, char text){
        this.color = color;
        this.type = type;
        this.text = text;
        figureTouched = false;
    }
    public ChessFigure (){
        text=' ';
        figureTouched = false;
    }

    public boolean checkPossibleMovement(ChessFigurePosition from , ChessFigurePosition to){
        //TODO add check for valid turn
        return figureTouched;
    };

    public ChessFigureColor getColor() {
        return color;
    }

    public void setColor(ChessFigureColor color) {
        this.color = color;
    }

    public ChessFigureType getType() {
        return type;
    }

    public void setType(ChessFigureType type) {
        this.type = type;
    }

    public char getText() {
        return text;
    }

    public void setText(char text) {
        this.text = text;
    }
    public String toString(){
        return String.valueOf(text);
    }
}
