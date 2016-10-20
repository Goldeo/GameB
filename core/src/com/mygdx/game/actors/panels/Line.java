package com.mygdx.game.actors.panels;

/**
 * Created by Sergey on 16.10.2016.
 */

public abstract class Line {

    private Cell cells[] = new Cell[10];

    public void setCell(int index, Cell cell) {
        cells[index] = cell;
    }

    public boolean check() {
        int n = 0;

        for (int i = 0; i < Field.CELL_COUNT; ++i) {
            if (!cells[i].isFull())
                break;
            else
                ++n;
        }

        return (n == Field.CELL_COUNT);
    }

    public void delete() {
        for (int i = 0; i < Field.CELL_COUNT; ++i) {
            if (cells[i].isFull())
                ((Panel) cells[i].getChildren().first()).delete();
        }
    }

}
