package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.GameB;
import com.mygdx.game.actors.buttons.PlayButton;

public class MenuScreen extends GameScreen {

    PlayButton playButton;

    public MenuScreen(GameB game) {
        super(game);
    }

    @Override
    protected void initialization() {
        playButton = new PlayButton(this);
        getStage().addActor(playButton);
    }

    @Override
    protected void setSettings() {
        playButton.setPosition(GameB.WIDTH / 2 - playButton.getWidth() / 2,
                GameB.HEIGHT / 2 - playButton.getHeight() / 2);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render(delta);
    }

    @Override
    public void dispose() {

    }


}
