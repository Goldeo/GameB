package com.mygdx.game.actors.panels;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RemoveActorAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeToAction;
import com.mygdx.game.GameB;
import com.mygdx.game.actors.figures.Figure;
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

    private MoveByAction moveByActionLength = new MoveByAction();
    private MoveByAction moveByActionMediumLength = new MoveByAction();
    private MoveToAction moveToActionBigLength = new MoveToAction();
    private MoveByAction moveByActionDelete = new MoveByAction();

    private SizeToAction sizeToActionLength = new SizeToAction();
    private SizeToAction sizeToActionMediumLength = new SizeToAction();
    private SizeToAction sizeToActionBigLength = new SizeToAction();
    private SizeToAction sizeToActionDelete = new SizeToAction();

    private RemoveActorAction removeActorAction = new RemoveActorAction();

    private ParallelAction parallelActionLength = new ParallelAction(moveByActionLength, sizeToActionLength);
    private ParallelAction parallelActionMediumLength = new ParallelAction(moveByActionMediumLength, sizeToActionMediumLength);
    private ParallelAction parallelActionBigLength = new ParallelAction(moveToActionBigLength, sizeToActionBigLength);
    private ParallelAction parallelActionDelete = new ParallelAction(moveByActionDelete, sizeToActionDelete);
    private SequenceAction sequenceActionDelete = new SequenceAction(parallelActionDelete, removeActorAction);

    private int row;
    private int column;

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

        moveByActionLength.setAmount(-this.column * MOVE_AMOUNT, -this.row * MOVE_AMOUNT);
        moveByActionLength.setDuration(NO_DURATION);
        sizeToActionLength.setSize(LENGTH, LENGTH);
        sizeToActionLength.setDuration(NO_DURATION);

        moveByActionMediumLength.setAmount(this.column * MOVE_AMOUNT, this.row * MOVE_AMOUNT);
        moveByActionMediumLength.setDuration(NO_DURATION);
        sizeToActionMediumLength.setSize(MEDIUM_LENGTH, MEDIUM_LENGTH);
        sizeToActionMediumLength.setDuration(NO_DURATION);

        moveToActionBigLength.setDuration(DURATION);
        sizeToActionBigLength.setSize(BIG_LENGTH, BIG_LENGTH);
        sizeToActionBigLength.setDuration(0);

        moveByActionDelete.setAmount(BIG_LENGTH / 2, BIG_LENGTH / 2);
        moveByActionDelete.setDuration(DURATION);
        sizeToActionDelete.setSize(0, 0);
        sizeToActionDelete.setDuration(DURATION);
    }

    public void incSize() {
        parallelActionMediumLength.restart();
        addAction(parallelActionMediumLength);
    }

    public void decSize() {
        parallelActionLength.restart();
        addAction(parallelActionLength);
    }

    public boolean isInsideCell(Cell cell) {
        return (!cell.isFull() && rectangleBounds.overlaps(cell.getRectangleBounds()));
    }

    public void stickPanel(Cell cell) {
        setPosition(getAbsX() - cell.getAbsX(), getAbsY() - cell.getAbsY());
        cell.addActor(this);
        screen.getScoreLabel().addPoints(1);
        moveToActionBigLength.setPosition(0, 0);
        moveToActionBigLength.restart();
        sizeToActionBigLength.restart();
        addAction(parallelActionBigLength);
    }

    public void delete() {
        screen.getScoreLabel().addPoints(1);
        moveByActionDelete.restart();
        sizeToActionDelete.restart();
        addAction(sequenceActionDelete);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

}
