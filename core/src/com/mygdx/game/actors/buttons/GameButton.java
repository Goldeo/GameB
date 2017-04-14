package com.mygdx.game.actors.buttons;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.managers.Assets;
import com.mygdx.game.screens.GameScreen;

/**
 * Created by Sergey on 13.04.2017.
 */
public abstract class GameButton extends Button {
    protected ButtonStyle style = new ButtonStyle();
    protected Screen screen;
    protected Skin skin;

    public GameButton(GameScreen screen) {
        this.screen = screen;
        skin = new Skin(screen.getGame().getAssets().getAssetManager().get(Assets.atlasPath, TextureAtlas.class));
        setStyle(style);
    }

    public Screen getScreen() {
        return screen;
    }
}
