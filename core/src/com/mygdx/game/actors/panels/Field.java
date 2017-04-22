package com.mygdx.game.actors.panels;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.GameB;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.PlayScreen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Field extends Group {
    public static final int BONUS_POINTS_100 = 100;
    public static final int BONUS_POINTS_250 = 250;

    public static final int CELL_COUNT = 10;
    private static final int SPACING = 2;
    private GameScreen screen;
    private CellsArray cellsArray;

    public Field(GameScreen screen, float x, float y) {
        this.screen = screen;
        cellsArray = new CellsArray(this);

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
                cellsArray.setCell(i, j, cell);
            }
        }
    }

    public GameScreen getScreen() {
        return screen;
    }

    public List<Cell> getCellsArray() {
        List<Cell> c = new ArrayList<Cell>();

        for (int i = 0; i < Field.CELL_COUNT; ++i) {
            for (int j = 0; j < Field.CELL_COUNT; ++j) {
                c.add(cellsArray.getCells()[i][j]);
            }
        }
        return c;
    }

    public void check(ArrayList<Cell> cellsList) {
        cellsArray.checkLines(cellsList);
        if (cellsArray.isGameOver()) {
            playGameOverSound();
        }
    }

    public void addBonusPoints(int points) {
        ((PlayScreen) screen).getScoreLabel().addPoints(points);
    }

    public void playBonusSound() {
        screen.getGame().getAssetManager().get(GameB.PLASTIC_SOUND1_PATH, Sound.class).play();
    }

    public void playClearSound() {
        screen.getGame().getAssetManager().get(GameB.SWISH_SOUND1_PATH, Sound.class).play();
    }

    public void playGameOverSound() {
        screen.getGame().getAssetManager().get(GameB.NEGATIVE_SOUND1_PATH, Sound.class).play();
    }
}
