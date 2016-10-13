package com.mygdx.game.actors.panels;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeByAction;
import com.mygdx.game.GameB;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Panel extends AbstractPanel {

    public static final float LENGTH = 20;

    private static final float SIZE_AMOUNT = 14;
    private static final float MOVE_AMOUNT = 18;
    private static final float DURATION = 0.2f;
    private MoveByAction moveByActionDec = new MoveByAction();
    private MoveByAction moveByActionInc = new MoveByAction();
    private SizeByAction sizeByActionDec = new SizeByAction();
    private SizeByAction sizeByActionInc = new SizeByAction();
    private ParallelAction parallelActionDec = new ParallelAction(moveByActionDec, sizeByActionDec);
    private ParallelAction parallelActionInc = new ParallelAction(moveByActionInc, sizeByActionInc);
    private int row;
    private int column;

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
        rectangle = new Rectangle(x, y, LENGTH, LENGTH);
    }

    public void setActions(int x, int y) {
        this.row = x;
        this.column = y;

        moveByActionDec.setAmount(-column * MOVE_AMOUNT, -row * MOVE_AMOUNT );
        moveByActionDec.setDuration(DURATION);

        moveByActionInc.setAmount(column * MOVE_AMOUNT, row * MOVE_AMOUNT);
        moveByActionInc.setDuration(DURATION);

        sizeByActionDec.setAmount(-SIZE_AMOUNT, -SIZE_AMOUNT);
        sizeByActionDec.setDuration(DURATION);

        sizeByActionInc.setAmount(SIZE_AMOUNT, SIZE_AMOUNT);
        sizeByActionInc.setDuration(DURATION);

    }

    public void decSize() {
        parallelActionDec.restart();
        addAction(parallelActionDec);
    }

    public void incSize() {
        parallelActionInc.restart();
        addAction(parallelActionInc);
    }

    /*public boolean isInideField() {
        if ((getX() + getWidth() / 2 > 0)) {

        }
    }*/
}
