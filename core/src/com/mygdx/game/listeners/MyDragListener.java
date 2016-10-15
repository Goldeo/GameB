package com.mygdx.game.listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.mygdx.game.actors.figures.Figure;

/**
 * Created by Sergey on 11.10.2016.
 */

public class MyDragListener extends DragListener {

    private Figure figure;

    public MyDragListener(Figure figure) {
        this.figure = figure;
    }

    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {
        super.drag(event, x, y, pointer);
        figure.setPosition(figure.getX() - figure.getWidth() / 2 + x, figure.getY() + y);
        figure.repositionPanels();
    }

    @Override
    public void dragStart(InputEvent event, float x, float y, int pointer) {
        super.dragStart(event, x, y, pointer);
        figure.incSize();
        figure.repositionPanels();
    }

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer) {
        super.dragStop(event, x, y, pointer);
        //figure.goToStandardPosition();
        figure.repositionPanels();
        figure.check();
    }

    @Override
    public void touchDragged(InputEvent event, float x, float y, int pointer) {
        super.touchDragged(event, x, y, pointer);

    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        return super.touchDown(event, x, y, pointer, button);

    }
}
