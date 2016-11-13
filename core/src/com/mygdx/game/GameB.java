package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.screens.PlayScreen;

public class GameB extends Game {

    public static Preferences prefs;
    public static TextureAtlas atlas;
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    public static Skin skin;
    public static State state;

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

    public static void setGameState(State state) {
        GameB.state = state;
    }

    @Override
    public void create() {
        atlas = new TextureAtlas(Gdx.files.internal("atlases/atlas.pack"));
        prefs = Gdx.app.getPreferences("Preferences");
        skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        skin.addRegions(atlas);

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
        atlas.dispose();
        skin.dispose();
    }
}
