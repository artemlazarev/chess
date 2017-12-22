package com.lazarev.edu.game.chess.client.gui;

import com.lazarev.edu.game.chess.logic.ChessFigure;

public class ChessFigureGUI extends ChessFigure {

    public ChessFigureGUI(ChessFigure c) {
        super(c.getColor(),c.getType(),c.getText());
    }
}
