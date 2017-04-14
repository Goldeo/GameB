package com.mygdx.game.actors.text;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GameB;
import com.mygdx.game.screens.GameScreen;

/**
 * Created by Sergey on 21.10.2016.
 */

public class RecordLabel extends AbstractLabel {

    private ScoreLabel scoreLabel;

    public RecordLabel(CharSequence text, GameScreen screen, String fontName, Color color) {
        super(text, screen, fontName, color);
    }

    public void setScoreLabel(ScoreLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    @Override
    public void savePoints() {
        if (scoreLabel.getPoints() > points) {
            prefs.putLong("Record", scoreLabel.getPoints());
            prefs.flush();
        }
    }

    @Override
    public void loadPoints() {
        setPoints(prefs.getLong("Record"));
    }

}
