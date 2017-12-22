package com.lazarev.edu.game.chess.logic;

public class InitLayout {
    public final static int F_LENGH = 8;
    public static final char[][] board = new char[][] {
            {'♖', '♘', '♗', '♕', '♔', '♗', '♘', '♖'},
            {'♙', '♙', '♙', '♙', '♙', '♙', '♙', '♙'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'♟', '♟', '♟', '♟', '♟', '♟', '♟', '♟'},
            {'♜', '♞', '♝', '♛', '♚', '♝', '♞', '♜'}
    };

    public static final ChessFigure[][] boardChess = new ChessFigure[][] {
            {new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.ROOK,board[0][0] ), new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.KNIGHT, board[0][1]), new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.BISHOP, board[0][2] ),  new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.QUEEN, board[0][3] ),  new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.KING, board[0][4] ), new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.BISHOP, board[0][5]), new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.KNIGHT, board[0][6]), new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.ROOK, board[0][7])},
            {new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.PAWN, board[1][0]), new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.PAWN, board[1][1] ), new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.PAWN, board[1][2] ), new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.PAWN, board[1][3] ), new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.PAWN, board[1][4] ), new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.PAWN, board[1][5] ), new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.PAWN, board[1][6] ), new ChessFigure(ChessFigureColor.BLACK, ChessFigureType.PAWN, board[1][7] )},
            {new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure()},
            {new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure()},
            {new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure()},
            {new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure(), new ChessFigure()},
            {new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.PAWN, board[6][0]), new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.PAWN, board[6][1] ), new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.PAWN, board[6][2]), new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.PAWN, board[6][3]), new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.PAWN, board[6][4]), new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.PAWN, board[6][5]), new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.PAWN, board[6][6]), new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.PAWN, board[7][7])},
            {new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.ROOK, board[7][0]), new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.KNIGHT, board[7][1]), new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.BISHOP, board[7][2]),  new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.QUEEN, board[7][3]),  new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.KING, board[7][4]), new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.BISHOP, board[7][5]), new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.KNIGHT, board[7][6]), new ChessFigure(ChessFigureColor.WHITE, ChessFigureType.ROOK, board[7][7])}
    };
    public static ChessFigureColor getSquaresColor(int i,int j) {
        int oddLine;
        if(( (i*F_LENGH+j) / F_LENGH)%2 == 1)
            oddLine=1;
        else
            oddLine=0;
        return  (i*F_LENGH+j)%2 == oddLine? ChessFigureColor.WHITE: ChessFigureColor.BLACK;
    }
}
