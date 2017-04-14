package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.screens.PlayScreen;

public class GameB extends Game {
    public static final String ATLAS_PATH = "atlases/atlas.pack";
    public static final String SKIN_PATH = "skins/uiskin.json";
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    public State state;

    private Preferences prefs;
    private AssetManager assetManager;
    private MenuScreen menuScreen;
    private PlayScreen playScreen;

    public enum Screen {
        MENU_SCREEN,
        PLAY_SCREEN
    }

    public enum State {
        RUNNING, PAUSED
    }

    private void loadAssets() {
        assetManager = new AssetManager();
        assetManager.load(ATLAS_PATH, TextureAtlas.class);
        assetManager.load(SKIN_PATH, Skin.class);
        assetManager.finishLoading();
    }

    public void setScreen(Screen screen) {
        switch (screen) {
            case MENU_SCREEN:
                setScreen(menuScreen);
                break;
            case PLAY_SCREEN:
                setScreen(playScreen);
                break;
        }
    }

    public void setGameState(State state) {
        this.state = state;
    }

    @Override
    public void create() {
        loadAssets();
        prefs = Gdx.app.getPreferences("Preferences");
        menuScreen = new MenuScreen(this);
        playScreen = new PlayScreen(this);

        setScreen(Screen.MENU_SCREEN);
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
        assetManager.dispose();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public Preferences getPrefs() {
        return prefs;
    }
}
