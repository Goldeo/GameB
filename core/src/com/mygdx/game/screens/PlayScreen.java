package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.GameB;
import com.mygdx.game.actors.buttons.PauseButton;
import com.mygdx.game.actors.figures.FigureGroup;
import com.mygdx.game.actors.panels.Field;

public class PlayScreen extends GameScreen {

    private Field field;
    private PauseButton pauseButton;
    private FigureGroup figureGroup;

    public PlayScreen(GameB game) {
        super(game);
    }

    @Override
    protected void initialization() {
        pauseButton = new PauseButton(this);
        field = new Field();
        figureGroup = new FigureGroup();
    }

    @Override
    protected void setSettings() {
        pauseButton.setPosition(GameB.WIDTH - pauseButton.getWidth() - 15, GameB.HEIGHT - pauseButton.getHeight() - 10);
        field.setPosition(GameB.WIDTH / 2, 500);

        figureGroup.setPosition(15, 100);

        stage.addActor(pauseButton);
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

    }

    @Override
    public void dispose() {

    }


    /*@Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        figureGroup.setPosition(screenX, GameB.HEIGHT - screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }*/


}
