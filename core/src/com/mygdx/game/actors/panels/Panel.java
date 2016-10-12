package com.mygdx.game.actors.panels;

import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeByAction;
import com.mygdx.game.GameB;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Panel extends AbstractPanel {

    public static final float LENGTH = 20;

    private static final float SIZE_AMOUNT = 14;
    private static final float MOVE_AMOUNT = 18;
    private MoveByAction moveByActionDec = new MoveByAction();
    private MoveByAction moveByActionInc = new MoveByAction();
    private SizeByAction sizeByActionDec = new SizeByAction();
    private SizeByAction sizeByActionInc = new SizeByAction();
    private int row;
    private int column;

    public enum Color {
        AQUA, BLUE, GREEN, LIME, ORANGE, PINK, PURPLE, RED, YELLOW
    }

    public Panel(Color color) {

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

        setSize(LENGTH, LENGTH);
    }

    public void setActions(int x, int y) {
        this.row = x;
        this.column = y;

        moveByActionDec.setAmount(-column * MOVE_AMOUNT, -row * MOVE_AMOUNT );
        moveByActionDec.setDuration(0.2f);

        moveByActionInc.setAmount(column * MOVE_AMOUNT, row * MOVE_AMOUNT);
        moveByActionInc.setDuration(0.2f);

        sizeByActionDec.setAmount(-SIZE_AMOUNT, -SIZE_AMOUNT);
        sizeByActionDec.setDuration(0.2f);

        sizeByActionInc.setAmount(SIZE_AMOUNT, SIZE_AMOUNT);
        sizeByActionInc.setDuration(0.2f);
    }

    public void decSize() {
        sizeByActionDec.restart();
        moveByActionDec.restart();

        addAction(sizeByActionDec);
        addAction(moveByActionDec);
    }

    public void incSize() {
        sizeByActionInc.restart();
        moveByActionInc.restart();

        addAction(sizeByActionInc);
        addAction(moveByActionInc);
    }
}
