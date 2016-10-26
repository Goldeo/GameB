package com.mygdx.game.actors.text;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by Sergey on 24.10.2016.
 */

public abstract class AbstractLabel extends Label {

    long points;

    public AbstractLabel(CharSequence text, Skin skin, String fontName, Color color) {
        super(text, skin, fontName, color);
        loadPoints();
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
        setText(String.valueOf(points));
    }

    public void addPoints(long addingPoints) {
        points += addingPoints;
        setText(String.valueOf(points));
    }

    public abstract void savePoints();
    public abstract void loadPoints();

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

}
