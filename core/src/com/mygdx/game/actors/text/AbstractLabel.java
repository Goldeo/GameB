package com.mygdx.game.actors.text;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GameB;
import com.mygdx.game.screens.GameScreen;

/**
 * Created by Sergey on 24.10.2016.
 */

public abstract class AbstractLabel extends Label {
    protected GameScreen screen;
    protected Preferences prefs;

    public AbstractLabel(CharSequence text, GameScreen screen, String fontName, Color color) {
        super(text, screen.getGame().getAssetManager().get(GameB.SKIN_PATH, Skin.class), fontName, color);
        this.screen = screen;
        prefs = screen.getGame().getPrefs();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
