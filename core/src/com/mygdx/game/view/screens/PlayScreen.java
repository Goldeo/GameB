package com.mygdx.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.GameB;
import com.mygdx.game.view.buttons.PauseButton;
import com.mygdx.game.view.figures.FigureGroup;
import com.mygdx.game.view.panels.Field;
import com.mygdx.game.view.text.RecordLabel;
import com.mygdx.game.view.text.ScoreLabel;
import com.mygdx.game.view.menus.PauseMenu;

public class PlayScreen extends GameScreen {
    private Field field;
    private PauseMenu pauseMenu;
    private PauseButton pauseButton;
    private FigureGroup figureGroup;
    private ScoreLabel  scoreLabel;
    private RecordLabel recordLabel;

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

    public PlayScreen() {
        super();
    }

    public PlayScreen(final GameB game) {
        super(game);
    }

    @Override
    protected void initialization() {
        pauseButton = new PauseButton(this);
        scoreLabel = new ScoreLabel("0", this, "default-font", new Color(0, 1, 0, 1));
        recordLabel = new RecordLabel("0", this, "default-font", new Color(0, 0, 1, 1));
        field = new Field(this, GameB.WIDTH / 2, GameB.HEIGHT / 2);
        figureGroup = new FigureGroup(this, 41, 0);

        pauseMenu = new PauseMenu(this);
    }

    @Override
    protected void setSettings() {
        pauseButton.setPosition(GameB.WIDTH - pauseButton.getWidth() - 15, GameB.HEIGHT - pauseButton.getHeight() - 10);
        scoreLabel.setPosition(100, 620);
        recordLabel.setPosition(300, 620);

        stage.addActor(pauseButton);
        stage.addActor(scoreLabel);
        stage.addActor(recordLabel);
        stage.addActor(field);
        stage.addActor(figureGroup);
        stage.addActor(pauseMenu);
    }

    public void showMenu() {
        pauseMenu.show();
    }

    public void hideMenu() {
        pauseMenu.hide();
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
