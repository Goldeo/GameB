package com.mygdx.game.actors.buttons;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GameB;
import com.mygdx.game.screens.GameScreen;

/**
 * Created by Sergey on 13.04.2017.
 */
public abstract class GameButton extends Button {
    protected ButtonStyle style = new ButtonStyle();
    protected GameScreen screen;
    protected Skin skin;

    public GameButton(GameScreen screen) {
        this.screen = screen;
        skin = new Skin(screen.getGame().getAssetManager().get(GameB.ATLAS_PATH, TextureAtlas.class));
        setStyle(style);
    }

    public GameScreen getScreen() {
        return screen;
    }
}