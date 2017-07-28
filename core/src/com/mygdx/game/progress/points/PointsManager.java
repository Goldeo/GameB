package com.mygdx.game.progress.points;

import com.badlogic.gdx.Preferences;
import com.mygdx.game.GameB;
import com.mygdx.game.progress.IProgress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 01.05.2017.
 */

public class PointsManager implements IProgress {
    private static final String SCORE_PREFS_NAME = "Score";
    private static final String RECORD_PREFS_NAME = "Record";
    private long scorePoints;
    private long recordPoints;
    private List<IScorePointsObserver> scorePointObservers;
    private List<IRecordPointsObserver> recordPointObservers;

    private Preferences prefs;

    public PointsManager(GameB game) {
        prefs = game.getPrefs();
        load();
        scorePointObservers = new ArrayList<>();
        recordPointObservers = new ArrayList<>();

        notifyScorePointsObservers();
        notifyRecordPointsObservers();
    }

    public void addObserver(IScorePointsObserver o) {
        scorePointObservers.add(o);
        notifyScorePointsObservers();
    }

    public void notifyScorePointsObservers() {
        scorePointObservers.forEach(p -> p.update(scorePoints));
    }

    public void addObserver(IRecordPointsObserver o) {
        recordPointObservers.add(o);
        notifyRecordPointsObservers();
    }

    public void notifyRecordPointsObservers() {
        recordPointObservers.forEach(p -> p.update(recordPoints));
    }

    public void addScorePoints(long points) {
        scorePoints += points;
        notifyScorePointsObservers();
        notifyRecordPointsObservers();
    }

    public void setToZero() {
        scorePoints = 0;
        notifyScorePointsObservers();
        notifyRecordPointsObservers();
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
