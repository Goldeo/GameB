package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.mygdx.game.managers.Assets;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.screens.PlayScreen;

public class GameB extends Game {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    public State state;

    private Preferences prefs;
    private Assets assets = new Assets();
    private MenuScreen menuScreen;
    private PlayScreen playScreen;

    public enum Screen {
        MENU_SCREEN,
        PLAY_SCREEN
    }

    public enum State {
        RUNNING, PAUSED
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
        prefs = Gdx.app.getPreferences("Preferences");
        assets.load();
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
        assets.dispose();
    }

    public Assets getAssets() {
        return assets;
    }

    public Preferences getPrefs() {
        return prefs;
    }
}
