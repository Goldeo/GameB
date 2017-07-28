package com.mygdx.game.view.text;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.progress.points.IRecordPointsObserver;
import com.mygdx.game.progress.points.IScorePointsObserver;
import com.mygdx.game.view.screens.GameScreen;

/**
 * Created by Sergey on 21.10.2016.
 */

public class RecordLabel extends AbstractLabel implements IRecordPointsObserver {
    public RecordLabel(CharSequence text, GameScreen screen, String fontName, Color color) {
        super(text, screen, fontName, color);
    }

    @Override
    public void update(long points) {
        setText(String.valueOf(points));
    }
}
