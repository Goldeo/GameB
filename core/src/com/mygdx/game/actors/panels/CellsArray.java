package com.mygdx.game.actors.panels;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.actors.figures.Figure;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.PlayScreen;

import java.util.ArrayList;

/**
 * Created by Sergey on 22.10.2016.
 */

public class CellsArray {

    private GameScreen screen;
    private Cell cells[][] = new Cell[Field.CELL_COUNT][Field.CELL_COUNT];
    private ArrayList<Integer> fullRows = new ArrayList<Integer>();
    private ArrayList<Integer> fullColumns = new ArrayList<Integer>();

    public CellsArray(GameScreen screen) {
        this.screen = screen;
    }

    public void setCell(int i, int j, Cell cell) {
        cells[i][j] = cell;
        cell.setRow(j);
        cell.setColumn(i);
    }

    public void checkLines(ArrayList<Cell> cellsList) {

        fullRows.clear();
        fullColumns.clear();

        for (Cell cell: cellsList) {
            checkHorizontalLine(cell.getRow());
            checkVerticalLine(cell.getColumn());
        }

        clearCells();
    }

    public boolean isGameOver() {
        int column;
        int row;
        int n;

        for (Actor actor: ((PlayScreen) screen).getFigureGroup().getChildren()) {

            Figure figure = (Figure) actor;

            for (int i = 0; i < Field.CELL_COUNT; ++i)
                for (int j = 0; j < Field.CELL_COUNT; ++j) {

                    n = 0;

                    for (Actor pan: figure.getChildren()) {
                        Panel panel = (Panel) pan;

                        column = panel.getColumn() + i;
                        row = panel.getRow() + j;

                        if (column < Field.CELL_COUNT && row < Field.CELL_COUNT)
                            if (cells[column][row].isFull())
                                break;
                            else
                                ++n;
                    }

                    if (n == figure.getPanelsCount())
                        return false;

                }

        }

        return true;
    }

    private void checkVerticalLine(int column) {
        int n = 0;

        for (int i = 0; i < Field.CELL_COUNT; ++i) {
            if (!cells[column][i].isFull())
                break;
            else
                ++n;
        }

        if (!fullColumns.contains(column) && n == Field.CELL_COUNT)
            fullColumns.add(column);
    }

    private void checkHorizontalLine(int row) {
        int n = 0;

        for (int i = 0; i < Field.CELL_COUNT; ++i) {
            if (!cells[i][row].isFull())
                break;
            else
                ++n;
        }

        if (!fullRows.contains(row) && n == Field.CELL_COUNT)
            fullRows.add(row);
    }

    private void clearCells() {
        for (int row: fullRows) {
            for (int i = 0; i < Field.CELL_COUNT; ++i) {
                if (cells[i][row].isFull()) {
                    ((Panel) cells[i][row].getChildren().first()).clearCell();
                    cells[i][row].setFull(false);
                }
            }
        }

        for (int column: fullColumns) {
            for (int i = 0; i < Field.CELL_COUNT; ++i) {
                if (cells[column][i].isFull()) {
                    ((Panel) cells[column][i].getChildren().first()).clearCell();
                    cells[column][i].setFull(false);
                }
            }
        }

        addBonusPoints();
    }

    private void addBonusPoints() {
        if (getFullLines() >= 5)
            ((PlayScreen) screen).getScoreLabel().addPoints(100);
        if (isEmptyField())
            ((PlayScreen) screen).getScoreLabel().addPoints(100);
    }

    private boolean isEmptyField() {
        int n = 0;

        for (int i = 0; i < Field.CELL_COUNT; ++i)
            for (int j = 0; j < Field.CELL_COUNT; ++j) {
                if (cells[i][j].isFull())
                    return false;
                else
                    ++n;
            }

        return (n == 100);
    }

    private int getFullLines() {
        return (fullRows.size() + fullColumns.size());
    }


}
