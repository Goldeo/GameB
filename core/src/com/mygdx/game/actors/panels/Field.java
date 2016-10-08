package com.mygdx.game.actors.panels;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Field extends Table {

    private static final int LENGTH = 10;
    private static final int SPACING = 5;

    public Field() {
        for (int i = 0; i < LENGTH; ++i) {
            for (int j = 0; j < LENGTH; ++j) {
                add(new Cell()).spaceRight(SPACING);
            }
            row().spaceTop(5);
        }
    }

}
