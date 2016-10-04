package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.GameB;

/**
 * Created by Sergey on 17.07.2016.
 */
public abstract class GameScreen implements Screen {
    protected GameB game;
    protected Stage stage;

    public GameScreen(final GameB game) {
        this.game = game;
        stage = new Stage(new StretchViewport(GameB.WIDTH, GameB.HEIGHT));
        initialization();
        setSettings();
    }

    public Stage getStage() {
        return stage;
    }

    public GameB getGame() {
        return game;
    }

    protected abstract void initialization();
    protected abstract void setSettings();

    @Override
    public void pause() {
        game.setGameState(GameB.State.PAUSED);
    }

    @Override
    public void resume() {
        game.setGameState(GameB.State.RUNNING);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void render(float delta) {
        switch(GameB.state) {
            case RUNNING:
                stage.act(delta);
                break;
            case PAUSED:
                break;
        }
        stage.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
