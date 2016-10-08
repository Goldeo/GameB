package com.mygdx.game.actors.figures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

/**
 * Created by Sergey on 05.10.2016.
 */

public abstract class Figure extends Table {

    private Vector2 standartPosition;
    private MoveByAction moveByAction;
    private SizeByAction sizeByAction;

    protected static final float SPACING = 2;

    public Figure() {

        addListener(new DragListener() {

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                setPosition(getX() + x - getWidth() / 2, getY() + y);
                Gdx.app.log("", "" + getWidth() + " " + getHeight());
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

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
    }

    protected void setStandartPosition() {
        standartPosition = new Vector2(getX(), getY());
        Gdx.app.log("", " " + getX() + " " + getY());
    }

    protected void goToStandartPosition() {

        MoveToAction moveToAction = new MoveToAction();
        moveToAction.setPosition(standartPosition.x, standartPosition.y);
        moveToAction.setDuration(0.35f);
        addAction(moveToAction);

        for (Actor actor: getChildren()) {
            sizeByAction = new SizeByAction();
            sizeByAction.setAmount(-10, -10);
            sizeByAction.setDuration(0.5f);

            moveByAction = new MoveByAction();
            moveByAction.setAmountX(-10);
            moveByAction.setDuration(0.5f);

            addAction(sizeByAction);
            addAction(moveByAction);
            Gdx.app.log("", "" + actor.getX());


        }

    }

    protected void incSize() {

        for (Actor actor: getChildren()) {
            sizeByAction = new SizeByAction();
            sizeByAction.setAmount(10, 10);
            sizeByAction.setDuration(0.5f);

            moveByAction = new MoveByAction();
            moveByAction.setAmountX(10);
            moveByAction.setDuration(0.5f);


            addAction(sizeByAction);
            addAction(moveByAction);
            //ParallelAction parallelAction = new ParallelAction(sizeByAction, moveByAction);
            //actor.addAction(parallelAction);
        }
    }

}
