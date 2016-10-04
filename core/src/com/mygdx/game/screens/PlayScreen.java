package com.mygdx.game.screens;

import com.mygdx.game.GameB;
import com.mygdx.game.actors.buttons.PlayButton;

public class PlayScreen extends GameScreen {

    PlayButton playButton;

    public PlayScreen(GameB game) {
        super(game);
    }

    @Override
    protected void initialization() {
        playButton = new PlayButton(this);
        getStage().addActor(playButton);
    }

    @Override
    protected void setSettings() {

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
