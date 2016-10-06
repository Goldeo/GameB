package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.screens.PlayScreen;

public class GameB extends Game {
    public static TextureAtlas atlas;
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    public static Skin skin;
    public static State state;

    public enum State {
        RUNNING, PAUSED
    }

    public void setGameState(State state) {
        this.state = state;
    }

    @Override
    public void create() {
        atlas = new TextureAtlas(Gdx.files.internal("atlases/atlas.pack"));
        skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        skin.addRegions(atlas);
        setScreen(new MenuScreen(this));
        setGameState(GameB.State.RUNNING);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        atlas.dispose();
        skin.dispose();
    }
}
