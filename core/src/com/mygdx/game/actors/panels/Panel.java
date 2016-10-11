package com.mygdx.game.actors.panels;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeByAction;
import com.mygdx.game.GameB;

/**
 * Created by Sergey on 05.10.2016.
 */

public abstract class Panel extends AbstractPanel {

    public static final float LENGTH = 25;
    protected static final float SIZE_AMOUNT = 10;
    protected static final float MOVE_AMOUNT = 10;
    protected MoveByAction moveByActionDec = new MoveByAction();
    protected MoveByAction moveByActionInc = new MoveByAction();
    protected SizeByAction sizeByActionDec = new SizeByAction();
    protected SizeByAction sizeByActionInc = new SizeByAction();
    protected float row;
    protected float column;

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

    public void setPos(float row, float column) {
        this.row = row;
        this.column = column;
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
