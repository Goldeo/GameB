package com.mygdx.game.actors.text;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by Sergey on 21.10.2016.
 */

public class ScoreLabel extends Label {

    private int points;

    public ScoreLabel(CharSequence text, Skin skin, String fontName, Color color) {
        super(text, skin, fontName, color);
    }

    public void addPoints(int addingPoints) {
        points += addingPoints;
        setText(String.valueOf(points));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
