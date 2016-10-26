package com.mygdx.game.actors.text;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GameB;

/**
 * Created by Sergey on 21.10.2016.
 */

public class RecordLabel extends AbstractLabel {

    private ScoreLabel scoreLabel;

    public RecordLabel(CharSequence text, Skin skin, String fontName, Color color) {
        super(text, skin, fontName, color);
    }

    public void setScoreLabel(ScoreLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    @Override
    public void savePoints() {
        if (scoreLabel.getPoints() > points) {
            GameB.prefs.putLong("Record", scoreLabel.getPoints());
            GameB.prefs.flush();
        }
    }

    @Override
    public void loadPoints() {
        setPoints(GameB.prefs.getLong("Record"));
    }

}
