package com.mygdx.game.actors.text;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.screens.GameScreen;

/**
 * Created by Sergey on 21.10.2016.
 */

public class ScoreLabel extends AbstractLabel {
    public ScoreLabel(CharSequence text, GameScreen screen, String fontName, Color color) {
        super(text, screen, fontName, color);
    }

    public void setToZero() {
        points = 0;
        savePoints();
    }

    @Override
    public void savePoints() {
        prefs.putLong("Score", points);
        prefs.flush();
    }

    @Override
    public void loadPoints() {
        setPoints(prefs.getLong("Score"));
    }
}
