package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.GameB;
import com.mygdx.game.actors.buttons.PauseButton;
import com.mygdx.game.actors.figures.FigureCreator;
import com.mygdx.game.actors.panels.Line;
import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.actors.panels.HorizontalLine;

public class PlayScreen extends GameScreen {

    private Field field;
    private PauseButton pauseButton;
    private FigureCreator figureCreator;

    public Field getField() {
        return field;
    }

    public FigureCreator getFigureCreator() {
        return figureCreator;
    }

    public PauseButton getPauseButton() {
        return pauseButton;
    }

    public PlayScreen(GameB game) {
        super(game);
    }

    @Override
    protected void initialization() {
        pauseButton = new PauseButton(this);
        field = new Field(this, GameB.WIDTH / 2, GameB.HEIGHT / 2);
        figureCreator = new FigureCreator(this, 41, 0);
    }

    @Override
    protected void setSettings() {
        pauseButton.setPosition(GameB.WIDTH - pauseButton.getWidth() - 15, GameB.HEIGHT - pauseButton.getHeight() - 10);

        stage.addActor(pauseButton);
        stage.addActor(field);
        stage.addActor(figureCreator);
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
