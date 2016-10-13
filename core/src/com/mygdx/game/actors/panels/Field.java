package com.mygdx.game.actors.panels;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Field extends Group {

    private static final int LENGTH = 10;
    private static final int SPACING = 2;

    public Field() {
        /*for (int i = 0; i < LENGTH; ++i) {
            for (int j = 0; j < LENGTH; ++j) {
                add(new Cell()).spaceRight(SPACING);
            }
            row().spaceTop(SPACING);
        }*/
        Cell cell;
        for (int i = 0; i < LENGTH; ++i) {
            for (int j = 0; j < LENGTH; ++j) {
                cell = new Cell();
                cell.setPosition(i * (Cell.LENGTH + SPACING), j * (Cell.LENGTH + SPACING));
                cell.setRectangle(new Rectangle(getX(), getY(), getWidth(), getHeight()));
                addActor(cell);
            }
        }

        float width = LENGTH * Cell.LENGTH + (LENGTH - 1) * SPACING;
        float height = LENGTH * Cell.LENGTH + (LENGTH - 1) * SPACING;

        setSize(width, height);
    }



}
