package com.lazarev.edu.game.chess.logic;


import static com.lazarev.edu.game.chess.logic.InitLayout.F_LENGH;

public abstract class ChessFigure{
    private ChessFigureColor color;
    private ChessFigureType type;
    private boolean figureTouched;
    protected boolean fistTurnFoFig = true;

    public Boolean getFigureTouched() {
        return figureTouched;
    }

    public void setFigureTouched(boolean figureTouched) {
        this.figureTouched = figureTouched;
    }
    //public ChessFigure (ChessFigureColor color, ChessFigureType type, char text){
    public ChessFigure (ChessFigureColor color, ChessFigureType type){
        this.color = color;
        this.type = type;
        //this.text = text;
        figureTouched = false;
    }
    public ChessFigure (){
        type = ChessFigureType.FREE;
        color=ChessFigureColor.WHITE;
        figureTouched = false;
    }
    public boolean  castling(){
        return fistTurnFoFig && (getType()==ChessFigureType.ROOK ||getType()== ChessFigureType.KING);
    }
    public boolean checkPossibleMovement(ChessFigurePosition from , ChessFigurePosition to, BoardLayout board)
    {
        //check for figure color at the destination position
        if(board.getFigAtPosition(to).getType()!=ChessFigureType.FREE)
            if(board.getFigAtPosition(to).getColor() == board.getFigAtPosition(from).getColor())
                return false;
        //check castling
        if(board.getFigAtPosition(from).castling() && board.getFigAtPosition(from).castling())
            return checkPossibleCastling(from , to, board);
        return checkPossibleMovementByType(from , to, board);
    };

    public boolean checkForCapture(ChessFigurePosition figureFrom , ChessFigurePosition to){
        return false;
    }

    //TODO implement
    public boolean checkPossibleCastling(ChessFigurePosition from , ChessFigurePosition to, BoardLayout board){
        //take the king
        int direction, len;
        if(board.getFigAtPosition(from).getType()==ChessFigureType.KING){
            len = from.getI()-to.getI();
            if(Math.abs(len)==2) {
                //direction = len>>1;
                checkForCapture(from,from);
                checkForCapture(from,new ChessFigurePosition(from.getI()+len>>1,from.getJ()));
                checkForCapture(from,new ChessFigurePosition(from.getI()+len,from.getJ()));
            return true;
            }

        }
        return false;
    }
    abstract public boolean checkPossibleMovementByType(ChessFigurePosition from , ChessFigurePosition to, BoardLayout board);


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

    //public char getText() { return text;   }

    //public void setText(char text) { this.text = text;   }
    public String toString(){
        return String.valueOf(type);
    }
}
