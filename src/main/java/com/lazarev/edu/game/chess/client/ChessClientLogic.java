package com.lazarev.edu.game.chess.client;

import com.lazarev.edu.game.chess.logic.BoardLayout;
import com.lazarev.edu.game.chess.logic.ChessFigure;
import com.lazarev.edu.game.chess.logic.ChessFigureNo;
import com.lazarev.edu.game.chess.logic.ChessFigurePosition;
import com.lazarev.edu.game.chess.server.GameMessage;

import javax.swing.*;
import java.awt.*;

public class ChessClientLogic implements GameMessageConsumer{
    private BoardLayout boardLayout;
    private ChessFigure curentChessFigure;
    ChessClientLogic (){
        boardLayout = BoardLayout.getBoardLayout();
    }

    @Override
    public void onMessage(GameMessage msg) {
        if(msg.getType()== GameMessage.MessageType.NEW_TURN)
            onMessage(new ChessFigurePosition( msg.getData()));
    }
    public boolean onMessage(ChessFigurePosition pos) {
        if(curentChessFigure==null)
            curentChessFigure = fig;
        if (curentChessFigure.getFigureTouched())
        {
            if(curentChessFigure.equals(fig)) {
                curentChessFigure.setFigureTouched(false);
                setBorder(BorderFactory.createLineBorder(color, 2));
            }
            if(curentChessFigure.checkPossibleMovement(curentPlayedPos, pos, boardLayout)) {
                boardLayout.setFigAtPosition(pos, curentChessFigure);
                boardLayout.setFigAtPosition(curentPlayedPos, new ChessFigureNo());
                board[curentPlayedPos.getI()][curentPlayedPos.getJ()].setChessFigure(new ChessFigureNo());
                setChessFigure(curentChessFigure);
                board[curentPlayedPos.getI()][curentPlayedPos.getJ()].setBorder(BorderFactory.createLineBorder(color, 2));
                curentChessFigure=null;
            }
            else ;

        }
        else {
            setBorder(BorderFactory.createLineBorder(Color.yellow,2));
            curentPlayedPos = pos;
            fig.setFigureTouched(true);
            curentChessFigure = fig;
        }
        return true;
    }
    public BoardLayout getBoardLayout(){
        return  boardLayout;
    }
}
