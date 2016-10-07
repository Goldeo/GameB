package com.mygdx.game.actors.figures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

/**
 * Created by Sergey on 05.10.2016.
 */

public abstract class Figure extends Table {

    private Vector2 standartPosition;
    private MoveToAction moveToAction;
    private ScaleByAction scaleByAction;
    protected static final float SPACING = 2;

    public Figure() {

        addListener(new DragListener() {

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                setPosition(getX() + x - getWidth() / 2, getY() + y - getHeight() / 2);
                incSize();
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void dragStart(InputEvent event, float x, float y, int pointer) {
                super.dragStart(event, x, y, pointer);
                incSize();
            }

            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer) {
                super.dragStop(event, x, y, pointer);
                goToStandartPosition();
            }
        });

    }

    protected void setStandartPosition() {
        standartPosition = new Vector2(getX(), getY());
    }

    protected void goToStandartPosition() {
        moveToAction = new MoveToAction();
        moveToAction.setPosition(standartPosition.x, standartPosition.y);
        moveToAction.setDuration(0.35f);
        addAction(moveToAction);
    }

    protected void incSize() {
        scaleByAction = new ScaleByAction();
        scaleByAction.setAmount(2f);
        scaleByAction.setDuration(0.5f);
        addAction(scaleByAction);
    }
}
