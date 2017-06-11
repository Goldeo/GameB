package com.mygdx.game.progress.points;

import com.badlogic.gdx.Preferences;
import com.mygdx.game.GameB;
import com.mygdx.game.progress.IProgress;

/**
 * Created by Sergey on 01.05.2017.
 */

public class PointsManager implements IProgress {
    private static final String SCORE_PREFS_NAME = "Score";
    private static final String RECORD_PREFS_NAME = "Record";
    private long scorePoints;
    private long recordPoints;

    private Preferences prefs;

    public PointsManager(GameB game) {
        prefs = game.getPrefs();
        load();
    }

    public void addScorePoints(long points) {
        scorePoints += points;
    }

    public void setToZero() {
        scorePoints = 0;
        save();
    }

    @Override
    public void save() {
        prefs.putLong(SCORE_PREFS_NAME, scorePoints);
        prefs.putLong(RECORD_PREFS_NAME, recordPoints);
    }

    @Override
    public void load() {
        scorePoints = prefs.getLong(SCORE_PREFS_NAME);
        recordPoints = prefs.getLong(RECORD_PREFS_NAME);
    }
}
