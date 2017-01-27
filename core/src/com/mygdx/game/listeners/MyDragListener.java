package com.mygdx.game.listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.mygdx.game.actors.buttons.PauseButton;
import com.mygdx.game.actors.figures.Figure;
import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 11.10.2016.
 */

public class MyDragListener extends DragListener {

    private Figure figure;
    private PauseButton button;

    public MyDragListener(PlayScreen screen, Figure figure) {
        this.figure = figure;
        this.button = screen.getPauseButton();
    }

    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {
        super.drag(event, x, y, pointer);

        figure.setPosition(figure.getX() - figure.getWidth() / 2 + x, figure.getY() + y);
        figure.repositionPanels();
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        figure.incSize();
        figure.repositionPanels();
        return super.touchDown(event, x, y, pointer, button);
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        super.touchUp(event, x, y, pointer, button);
        figure.repositionPanels();
        figure.check();
    }
}
