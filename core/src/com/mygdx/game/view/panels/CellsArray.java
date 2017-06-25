package com.mygdx.game.view.panels;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.view.figures.Figure;
import com.mygdx.game.view.screens.GameScreen;
import com.mygdx.game.view.screens.PlayScreen;

import java.util.ArrayList;

/**
 * Created by Sergey on 22.10.2016.
 */

public class CellsArray {
    private GameScreen screen;
    private Field field;
    private Cell[][] cells = new Cell[Field.CELL_COUNT][Field.CELL_COUNT];
    private ArrayList<Integer> fullRowsCount = new ArrayList<Integer>();
    private ArrayList<Integer> fullColumnsCount = new ArrayList<Integer>();

    public CellsArray(Field field) {
        this.field = field;
        screen = field.getScreen();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCell(int i, int j, Cell cell) {
        cells[i][j] = cell;
        cell.setRow(j);
        cell.setColumn(i);
    }

    public void checkLines(ArrayList<Cell> cellsList) {
        fullRowsCount.clear();
        fullColumnsCount.clear();

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

            for (int i = 0; i < Field.CELL_COUNT; ++i) {
                for (int j = 0; j < Field.CELL_COUNT; ++j) {
                    n = 0;

                    for (Actor pan : figure.getChildren()) {
                        Panel panel = (Panel) pan;

                        column = panel.getColumn() + i;
                        row = panel.getRow() + j;

                        if (column < Field.CELL_COUNT && row < Field.CELL_COUNT) {
                            if (cells[column][row].isFull()) {
                                break;
                            } else {
                                ++n;
                            }
                        }
                    }

                    if (n == figure.getPanelsCount()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void checkVerticalLine(int column) {
        int n = 0;

        for (int i = 0; i < Field.CELL_COUNT; ++i) {
            if (!cells[column][i].isFull()) {
                break;
            } else {
                ++n;
            }
        }

        if (!fullColumnsCount.contains(column) && n == Field.CELL_COUNT) {
            fullColumnsCount.add(column);
        }
    }

    private void checkHorizontalLine(int row) {
        int n = 0;

        for (int i = 0; i < Field.CELL_COUNT; ++i) {
            if (!cells[i][row].isFull()) {
                break;
            } else {
                ++n;
            }
        }

        if (!fullRowsCount.contains(row) && n == Field.CELL_COUNT) {
            fullRowsCount.add(row);
        }
    }

    private void clearCells() {
        boolean flag = false;

        for (int row: fullRowsCount) {
            for (int i = 0; i < Field.CELL_COUNT; ++i) {
                if (cells[i][row].isFull()) {
                    cells[i][row].clearCell();
                    flag = true;
                }
            }
        }

        for (int column: fullColumnsCount) {
            for (int i = 0; i < Field.CELL_COUNT; ++i) {
                if (cells[column][i].isFull()) {
                    cells[column][i].clearCell();
                    flag = true;
                }
            }
        }

        if (flag) {
            field.playClearSound();
        }
        addBonusPoints();
    }

    private void addBonusPoints() {
        if (getFullLines() >= 5) {
            field.addBonusPoints(Field.BONUS_POINTS_100);
            field.playBonusSound();
        }

        if (isEmptyField()) {
            field.addBonusPoints(Field.BONUS_POINTS_250);
            field.playBonusSound();
        }
    }

    private boolean isEmptyField() {
        int n = 0;

        for (int i = 0; i < Field.CELL_COUNT; ++i) {
            for (int j = 0; j < Field.CELL_COUNT; ++j) {
                if (cells[i][j].isFull()) {
                    return false;
                } else {
                    ++n;
                }
            }
        }
        return (n == 100);
    }

    private int getFullLines() {
        return (fullRowsCount.size() + fullColumnsCount.size());
    }
}
