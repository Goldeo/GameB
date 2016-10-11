package com.mygdx.game.actors.figures;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.listeners.MyDragListener;

/**
 * Created by Sergey on 05.10.2016.
 */

public abstract class Figure extends Group {

    private Vector2 standardPosition = new Vector2();
    private MoveToAction moveToAction = new MoveToAction();

    protected static final float SPACING = 2;
    protected static final float PANEL_LENGTH = SPACING + Panel.LENGTH;

    public Figure() {
        addListener(new MyDragListener(this));
    }

    public void setStandartPosition() {
        standardPosition.set(getX(), getY());
    }

    public void goToStandardPosition() {
        moveToAction.setPosition(standardPosition.x, standardPosition.y);
        moveToAction.setDuration(0.2f);

        for (Actor panel: getChildren()) {
            ((Panel) panel).decSize();
        }

        moveToAction.restart();
        addAction(moveToAction);
    }

    public void incSize() {
        for (Actor panel: getChildren()) {
            ((Panel) panel).incSize();
        }
    }

}
