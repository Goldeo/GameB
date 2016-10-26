package com.mygdx.game.actors.panels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.screens.PlayScreen;

import java.util.ArrayList;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Field extends Group {

    public static final int CELL_COUNT = 10;
    private static final int SPACING = 2;
    private PlayScreen screen;
    private CellsArray cells;

    public Field(PlayScreen screen, float x, float y) {
        this.screen = screen;
        cells = new CellsArray(screen);

        float width = CELL_COUNT * Cell.LENGTH + (CELL_COUNT - 1) * SPACING;
        float height = CELL_COUNT * Cell.LENGTH + (CELL_COUNT - 1) * SPACING;

        setSize(width, height);
        setPosition(x - width / 2, y - width / 2);

        Cell cell;
        for (int i = 0; i < CELL_COUNT; ++i) {
            for (int j = 0; j < CELL_COUNT; ++j) {
                cell = new Cell(this);
                cell.setPosition(i * (Cell.LENGTH + SPACING), j * (Cell.LENGTH + SPACING));
                cell.setRectangleBounds();
                addActor(cell);
                cells.setCell(i, j, cell);
            }
        }
    }

    public void check(ArrayList<Cell> cellsList) {
        boolean b;
        cells.checkLines(cellsList);
        b = cells.isGameOver();
        Gdx.app.log("b", "" + b);
    }

}
