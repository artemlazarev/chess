package com.lazarev.edu.game.chess.logic;

import static  com.lazarev.edu.game.chess.logic.ChessFigureColor.BLACK;
import static  com.lazarev.edu.game.chess.logic.ChessFigureColor.WHITE;
public class InitLayout {
    public final static int F_LENGH = 8;
    public int getBoardSize(){return  F_LENGH;}

    public static final ChessFigure[][] boardChess = new ChessFigure[][] {
            {new ChessFigureRook(BLACK), new ChessFigureKnight(BLACK), new ChessFigureBishop(BLACK),  new ChessFigureQueen(BLACK),  new ChessFigureKing(BLACK), new ChessFigureBishop(BLACK), new ChessFigureKnight(BLACK), new ChessFigureRook(BLACK)},
            {new ChessFigurePawn(BLACK), new ChessFigurePawn(BLACK), new ChessFigurePawn(BLACK ), new ChessFigurePawn(BLACK ), new ChessFigurePawn(BLACK), new ChessFigurePawn(BLACK), new ChessFigurePawn(BLACK), new ChessFigurePawn(BLACK)},
            {new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo()},
            {new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo()},
            {new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo()},
            {new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo(), new ChessFigureNo()},
            {new ChessFigurePawn(WHITE), new ChessFigurePawn(WHITE), new ChessFigurePawn(WHITE ), new ChessFigurePawn(WHITE ), new ChessFigurePawn(WHITE), new ChessFigurePawn(WHITE), new ChessFigurePawn(WHITE), new ChessFigurePawn(WHITE)},
            {new ChessFigureRook(WHITE), new ChessFigureKnight(WHITE), new ChessFigureBishop(WHITE),  new ChessFigureQueen(WHITE),  new ChessFigureKing(WHITE), new ChessFigureBishop(WHITE ), new ChessFigureKnight(WHITE), new ChessFigureRook(WHITE)}
    };
    public static ChessFigureColor getSquaresColor(int i,int j) {
        int oddLine;
        if(( (i*F_LENGH+j) / F_LENGH)%2 == 1)
            oddLine=1;
        else
            oddLine=0;
        return  (i*F_LENGH+j)%2 == oddLine? WHITE: BLACK;
    }
}
