package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.GameB;
import com.mygdx.game.actors.buttons.PauseButton;
import com.mygdx.game.actors.figures.FigureGroup;
import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.actors.text.ScoreLabel;

public class PlayScreen extends GameScreen {

    private Field field;
    private PauseButton pauseButton;
    private FigureGroup figureGroup;
    private ScoreLabel scoreLabel;

    public Field getField() {
        return field;
    }

    public FigureGroup getFigureGroup() {
        return figureGroup;
    }

    public PauseButton getPauseButton() {
        return pauseButton;
    }

    public ScoreLabel getScoreLabel() {
        return scoreLabel;
    }

    public PlayScreen(GameB game) {
        super(game);
    }

    @Override
    protected void initialization() {
        pauseButton = new PauseButton(this);
        scoreLabel = new ScoreLabel("0", GameB.skin, "default-font", new Color(1, 0, 0, 1));

        field = new Field(this, GameB.WIDTH / 2, GameB.HEIGHT / 2);
        figureGroup = new FigureGroup(this, 41, 0);
    }

    @Override
    protected void setSettings() {
        pauseButton.setPosition(GameB.WIDTH - pauseButton.getWidth() - 15, GameB.HEIGHT - pauseButton.getHeight() - 10);
        scoreLabel.setPosition(100, 600);
        scoreLabel.setColor(0, 1, 0, 1);

        stage.addActor(pauseButton);
        stage.addActor(scoreLabel);
        stage.addActor(field);
        stage.addActor(figureGroup);
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
