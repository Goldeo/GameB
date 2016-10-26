package com.mygdx.game.actors.text;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GameB;

/**
 * Created by Sergey on 21.10.2016.
 */

public class ScoreLabel extends AbstractLabel {

    public ScoreLabel(CharSequence text, Skin skin, String fontName, Color color) {
        super(text, skin, fontName, color);
    }

    public void setToZero() {
        points = 0;
    }

    @Override
    public void savePoints() {
        GameB.prefs.putLong("Score", points);
        GameB.prefs.flush();
    }

    @Override
    public void loadPoints() {
        setPoints(GameB.prefs.getLong("Score"));
    }
}
