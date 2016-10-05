package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.GameB;
import com.mygdx.game.actors.buttons.PauseButton;
import com.mygdx.game.actors.figures.Figure2;
import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.actors.figures.Figure;
import com.mygdx.game.actors.figures.Figure1;

public class PlayScreen extends GameScreen {

    private Field field;
    private PauseButton pauseButton;
    Figure fig1;
    Figure fig2;

    public PlayScreen(GameB game) {
        super(game);
    }

    @Override
    protected void initialization() {
        pauseButton = new PauseButton(this);
        field = new Field();
        fig1 = new Figure1();
        fig2 = new Figure2();
    }

    @Override
    protected void setSettings() {
        pauseButton.setPosition(GameB.WIDTH - pauseButton.getWidth() - 15, GameB.HEIGHT - pauseButton.getHeight() - 10);
        field.setPosition(GameB.WIDTH / 2, 500);
        fig1.setPosition(100, 100);
        fig2.setPosition(200, 100);

        stage.addActor(pauseButton);
        stage.addActor(field);
        stage.addActor(fig1);
        stage.addActor(fig2);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render(delta);
    }


    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {

    }


}
