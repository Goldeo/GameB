package com.mygdx.game.actors.panels;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Field extends com.mygdx.game.actors.figures.Figure {

    private static final int LENGTH = 10;

    public Field() {

        for (int i = 0; i < LENGTH; ++i) {
            for (int j = 0; j < LENGTH; ++j) {
                add(new Cell()).spaceRight(5);
            }
            row().spaceTop(5);
        }

    }
}
