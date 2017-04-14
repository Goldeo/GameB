package com.mygdx.game.actors.panels;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Panel extends AbstractPanel {
    public static final float LENGTH = 20;
    public static final float MEDIUM_LENGTH = 34;
    public static final float BIG_LENGTH = 38;
    private static final float MOVE_AMOUNT = BIG_LENGTH - LENGTH;
    private static final float POINT_LENGTH = 2.0001f;
    private static final float DURATION = 0.1f;
    private static final float NO_DURATION = 0;

    @Override
    public void setRectangleBounds() {
        float x = getAbsX() + getWidth() / 2 - POINT_LENGTH  / 2;
        float y = getAbsY() + getHeight() / 2 - POINT_LENGTH  / 2;

        rectangleBounds.set(x, y, POINT_LENGTH, POINT_LENGTH);
    }

    @Override
    public float getAbsX() {
        if (getParent().getParent() != null) {
            return getParent().getX() + getParent().getParent().getX() + getX();
        }
        else return 0;
    }

    @Override
    public float getAbsY() {
        if (getParent().getParent() != null) {
            return getParent().getY() + getParent().getParent().getY() + getY();
        }
        else return 0;
    }

    public enum Color {
        AQUA, BLUE, GREEN, LIME, ORANGE, PINK, PURPLE, RED, YELLOW
    }

    public Panel(GameScreen screen, Color color, float x, float y) {
        super(screen);

        switch (color) {
            case LIME:
                texture = atlas.findRegion("limePanel");
                break;
            case BLUE:
                texture = atlas.findRegion("bluePanel");
                break;
            case RED:
                texture = atlas.findRegion("redPanel");
                break;
            case PURPLE:
                texture = atlas.findRegion("purplePanel");
                break;
            case YELLOW:
                texture = atlas.findRegion("yellowPanel");
                break;
            case AQUA:
                texture = atlas.findRegion("aquaPanel");
                break;
            case ORANGE:
                texture = atlas.findRegion("orangePanel");
                break;
            case GREEN:
                texture = atlas.findRegion("greenPanel");
                break;
            case PINK:
                texture = atlas.findRegion("pinkPanel");
                break;
            default:
                break;
        }

        setBounds(x, y, LENGTH, LENGTH);
    }

    public void setActions(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void incSize() {
        addAction(Actions.parallel(Actions.moveBy(column * MOVE_AMOUNT, row * MOVE_AMOUNT, NO_DURATION),
                Actions.sizeTo(MEDIUM_LENGTH, MEDIUM_LENGTH, NO_DURATION)));
    }

    public void decSize() {
        addAction(Actions.parallel(Actions.moveBy(-column * MOVE_AMOUNT, -row * MOVE_AMOUNT, NO_DURATION),
                Actions.sizeTo(LENGTH, LENGTH, NO_DURATION)));
    }

    public boolean isInsideCell(Cell cell) {
        return (!cell.isFull() && rectangleBounds.overlaps(cell.getRectangleBounds()));
    }

    public void stickPanel(Cell cell) {
        setPosition(getAbsX() - cell.getAbsX(), getAbsY() - cell.getAbsY());
        cell.addActor(this);
        ((PlayScreen) screen).getScoreLabel().addPoints(1);

        addAction(Actions.parallel(Actions.moveTo(0, 0, DURATION),
                Actions.sizeTo(BIG_LENGTH, BIG_LENGTH, DURATION)));
    }

    public void clearCell() {
        ((PlayScreen) screen).getScoreLabel().addPoints(1);
        addAction(Actions.sequence(Actions.parallel(Actions.moveBy(BIG_LENGTH / 2, BIG_LENGTH / 2, DURATION),
                Actions.sizeTo(0, 0, DURATION)), Actions.removeActor()));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

}
