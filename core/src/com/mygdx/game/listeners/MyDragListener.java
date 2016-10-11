package com.mygdx.game.listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.mygdx.game.actors.figures.Figure;

/**
 * Created by Sergey on 11.10.2016.
 */

public class MyDragListener extends DragListener implements Cloneable {

    private Figure figure;

    public MyDragListener(Figure figure) {
        this.figure = figure;
    }

    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {
        super.drag(event, x, y, pointer);
        figure.setPosition(figure.getX() + x - figure.getWidth() / 2, figure.getY() + y);
    }

    @Override
    public void dragStart(InputEvent event, float x, float y, int pointer) {
        super.dragStart(event, x, y, pointer);

        figure.incSize();
    }

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer) {
        super.dragStop(event, x, y, pointer);
        figure.goToStandardPosition();

    }

}
