package com.mygdx.game.actors.panels;

import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeToAction;
import com.mygdx.game.GameB;

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

    private MoveByAction moveByActionLength = new MoveByAction();
    private MoveByAction moveByActionMediumLength = new MoveByAction();
    private MoveToAction moveToBigLength = new MoveToAction();

    private SizeToAction sizeToActionLength = new SizeToAction();
    private SizeToAction sizeToActionMediumLength = new SizeToAction();
    private SizeToAction sizeToActionBigLength = new SizeToAction();

    private ParallelAction parallelActionLength = new ParallelAction(moveByActionLength, sizeToActionLength);
    private ParallelAction parallelActionMediumLength = new ParallelAction(moveByActionMediumLength, sizeToActionMediumLength);
    private ParallelAction parallelActionBigLength = new ParallelAction(moveToBigLength, sizeToActionBigLength);

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
        return getParent().getX() + getX();
    }

    @Override
    public float getAbsY() {
        return getParent().getY() + getY();
    }

    public enum Color {
        AQUA, BLUE, GREEN, LIME, ORANGE, PINK, PURPLE, RED, YELLOW
    }

    public Panel(Color color, float x, float y) {

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

    public void setActions(int x, int y) {
        this.row = x;
        this.column = y;

        moveByActionLength.setAmount(-column * MOVE_AMOUNT, -row * MOVE_AMOUNT);
        moveByActionLength.setDuration(DURATION);
        sizeToActionLength.setSize(LENGTH, LENGTH);
        sizeToActionLength.setDuration(DURATION);

        moveByActionMediumLength.setAmount(column * MOVE_AMOUNT, row * MOVE_AMOUNT);
        moveByActionMediumLength.setDuration(DURATION);
        sizeToActionMediumLength.setSize(MEDIUM_LENGTH, MEDIUM_LENGTH);
        sizeToActionMediumLength.setDuration(DURATION / 4);

        moveToBigLength.setDuration(DURATION);
        sizeToActionBigLength.setSize(BIG_LENGTH, BIG_LENGTH);
        sizeToActionBigLength.setDuration(DURATION / 4);
    }

    public void incSize() {
        parallelActionMediumLength.restart();
        addAction(parallelActionMediumLength);
    }

    public void decSize() {
        parallelActionLength.restart();
        addAction(parallelActionLength);
    }

    public void stickPanel(Cell cell) {
        moveToBigLength.setPosition(cell.getAbsX() - getParent().getX(), cell.getAbsY() - getParent().getY());
        moveToBigLength.restart();
        sizeToActionBigLength.restart();

        addAction(parallelActionBigLength);
    }

    public boolean isInsideCell(Cell cell) {
        if (!cell.isFull() && rectangleBounds.overlaps(cell.getRectangleBounds()))
            return true;
        else
            return false;
    }

}
