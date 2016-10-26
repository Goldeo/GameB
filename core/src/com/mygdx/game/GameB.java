package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.screens.MenuScreen;

public class GameB extends Game {

    public static Preferences prefs;
    public static TextureAtlas atlas;
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    public static Skin skin;
    public static State state;

    public enum State {
        RUNNING, PAUSED
    }

    public static void setGameState(State state) {
        GameB.state = state;
    }

    @Override
    public void create() {
        atlas = new TextureAtlas(Gdx.files.internal("atlases/atlas.pack"));
        prefs = Gdx.app.getPreferences("Preferences");
        skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        skin.addRegions(atlas);
        setScreen(new MenuScreen(this));
        setGameState(State.RUNNING);
    }

    @Override
    public void pause() {
        super.pause();
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
