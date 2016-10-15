package com.mygdx.game.actors.panels;

import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Field extends Group {

    private static final int LENGTH = 10;
    private static final int SPACING = 2;

    public Field(float x, float y) {

        float width = LENGTH * Cell.LENGTH + (LENGTH - 1) * SPACING;
        float height = LENGTH * Cell.LENGTH + (LENGTH - 1) * SPACING;

        setSize(width, height);
        setPosition(x - width / 2, y - width / 2);

        Cell cell;
        for (int i = 0; i < LENGTH; ++i) {
            for (int j = 0; j < LENGTH; ++j) {
                cell = new Cell();
                addActor(cell);
                cell.setPosition(i * (Cell.LENGTH + SPACING), j * (Cell.LENGTH + SPACING));
                cell.setRectangleBounds();
            }
        }


    }



}
