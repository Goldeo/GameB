package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.GameB;
import com.mygdx.game.actors.buttons.PauseButton;
import com.mygdx.game.actors.figures.FigureCreator;
import com.mygdx.game.actors.panels.Field;

public class PlayScreen extends GameScreen {

    private Field field;
    private PauseButton pauseButton;
    private FigureCreator figureCreator;

    public PlayScreen(GameB game) {
        super(game);
    }

    @Override
    protected void initialization() {
        pauseButton = new PauseButton(this);
        field = new Field();
    }

    @Override
    protected void setSettings() {
        pauseButton.setPosition(GameB.WIDTH - pauseButton.getWidth() - 15, GameB.HEIGHT - pauseButton.getHeight() - 10);
        field.setPosition(GameB.WIDTH / 2 - field.getWidth() / 2, GameB.HEIGHT / 2 - field.getHeight() / 2);

        stage.addActor(pauseButton);
        stage.addActor(field);

        figureCreator = new FigureCreator(this, GameB.WIDTH / 2, 100);
        figureCreator.setField(field);
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
