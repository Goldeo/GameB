package com.mygdx.game.actors.panels;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RemoveActorAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeToAction;
import com.mygdx.game.GameB;
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
    private PlayScreen screen;

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

    public Panel(PlayScreen screen, Color color, float x, float y) {
        this.screen = screen;

        switch (color) {
            case LIME:
                texture = GameB.atlas.findRegion("limePanel");
                break;
            case BLUE:
                texture = GameB.atlas.findRegion("bluePanel");
                break;
            case RED:
                texture = GameB.atlas.findRegion("redPanel");
                break;
            case PURPLE:
                texture = GameB.atlas.findRegion("purplePanel");
                break;
            case YELLOW:
                texture = GameB.atlas.findRegion("yellowPanel");
                break;
            case AQUA:
                texture = GameB.atlas.findRegion("aquaPanel");
                break;
            case ORANGE:
                texture = GameB.atlas.findRegion("orangePanel");
                break;
            case GREEN:
                texture = GameB.atlas.findRegion("greenPanel");
                break;
            case PINK:
                texture = GameB.atlas.findRegion("pinkPanel");
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
        screen.getScoreLabel().addPoints(1);

        addAction(Actions.parallel(Actions.moveTo(0, 0, DURATION),
                Actions.sizeTo(BIG_LENGTH, BIG_LENGTH, DURATION)));
    }

    public void clearCell() {
        screen.getScoreLabel().addPoints(1);
        addAction(Actions.parallel(Actions.moveBy(BIG_LENGTH / 2, BIG_LENGTH / 2, DURATION),
                Actions.sizeTo(0, 0, DURATION)));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

}
