package com.mygdx.game.actors.panels;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Field extends Group {

    public static final int CELL_COUNT = 10;
    private static final int SPACING = 2;
    private PlayScreen screen;
    private Line horizontalLines[] = new HorizontalLine[CELL_COUNT];
    private Line verticalLines[] = new VerticalLine[CELL_COUNT];

    public Field(PlayScreen screen, float x, float y) {
        this.screen = screen;

        for (int i = 0; i < CELL_COUNT; ++i) {
            horizontalLines[i] = new HorizontalLine();
            verticalLines[i] = new VerticalLine();
        }

        float width = CELL_COUNT * Cell.LENGTH + (CELL_COUNT - 1) * SPACING;
        float height = CELL_COUNT * Cell.LENGTH + (CELL_COUNT - 1) * SPACING;

        setSize(width, height);
        setPosition(x - width / 2, y - width / 2);

        Cell cell;
        for (int i = 0; i < CELL_COUNT; ++i) {
            for (int j = 0; j < CELL_COUNT; ++j) {
                cell = new Cell(this);
                /*cell.setRow(j);
                cell.setColumn(i);*/
                cell.setPosition(i * (Cell.LENGTH + SPACING), j * (Cell.LENGTH + SPACING));
                cell.setRectangleBounds();
                addActor(cell);
                horizontalLines[j].setCell(i, cell);
                verticalLines[i].setCell(j, cell);
            }
        }
    }

    public void check() {
        boolean horizontalNumbers[] = new boolean[CELL_COUNT];
        boolean verticalNumbers[] = new boolean[CELL_COUNT];

        for (int i = 0; i < CELL_COUNT; ++i) {
            horizontalNumbers[i] = horizontalLines[i].check();
            verticalNumbers[i] = verticalLines[i].check();
        }

        for (int i = 0; i < CELL_COUNT; ++i) {
            if (horizontalNumbers[i])
                horizontalLines[i].delete();
            if (verticalNumbers[i])
                verticalLines[i].delete();
        }
    }


}
