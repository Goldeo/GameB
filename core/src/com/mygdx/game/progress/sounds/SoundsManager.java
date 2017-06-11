package com.mygdx.game.progress.sounds;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.GameB;
import com.mygdx.game.progress.IProgress;

/**
 * Created by Sergey on 30.04.2017.
 */

public class SoundsManager implements IProgress {
    public static final String SWAP_SOUND1_PATH = "sounds/swap_sound1.wav";
    public static final String SWAP_SOUND2_PATH = "sounds/swap_sound2.wav";
    public static final String PLASTIC_SOUND1_PATH = "sounds/plastic_sound1.wav";
    public static final String PLASTIC_SOUND2_PATH = "sounds/plastic_sound2.wav";
    public static final String PLASTIC_SOUND3_PATH = "sounds/plastic_sound3.wav";
    public static final String SWISH_SOUND1_PATH = "sounds/swish_sound1.wav";
    public static final String POSITIVE_SOUND1_PATH = "sounds/positive_sound1.wav";
    public static final String NEGATIVE_SOUND1_PATH = "sounds/negative_sound1.wav";

    public static final float SOUND_OFF_VOLUME = 0;
    public static final float SOUND_ON_VOLUME = 1;

    private float volume;
    private static final String SOUND_PREFS_NAME = "StateSound";
    private Preferences prefs;
    private AssetManager assetManager;
    private ISoundState soundState;

    public SoundsManager(GameB game) {
        prefs = game.getPrefs();
        load();

        assetManager = game.getAssetManager();
        assetManager.load(SWAP_SOUND1_PATH, Sound.class);
        assetManager.load(SWAP_SOUND2_PATH, Sound.class);
        assetManager.load(PLASTIC_SOUND1_PATH, Sound.class);
        assetManager.load(PLASTIC_SOUND2_PATH, Sound.class);
        assetManager.load(PLASTIC_SOUND3_PATH, Sound.class);
        assetManager.load(SWISH_SOUND1_PATH, Sound.class);
        assetManager.load(POSITIVE_SOUND1_PATH, Sound.class);
        assetManager.load(NEGATIVE_SOUND1_PATH, Sound.class);
    }

    public void switchSound() {
        if (isOn()) {
            off();
        } else {
            on();
        }
    }

    public void playSound(String path) {
        assetManager.get(path, Sound.class).play(volume);
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void saveSoundState() {
        if (isOn()) {
            prefs.putBoolean(SOUND_PREFS_NAME, true);
        } else {
            prefs.putBoolean(SOUND_PREFS_NAME, false);
        }
    }

    private void on() {
        soundState.on(this);
    }

    private void off() {
        soundState.off(this);
    }

    public void setSoundState(ISoundState soundState) {
        this.soundState = soundState;
    }

    public boolean isOn() {
        return soundState instanceof SoundOnState;
    }

    @Override
    public void save() {
        if (isOn()) {
            prefs.putBoolean(SOUND_PREFS_NAME, true);
        } else {
            prefs.putBoolean(SOUND_PREFS_NAME, false);
        }
    }

    @Override
    public void load() {
        if (prefs.getBoolean(SOUND_PREFS_NAME)) {
            setSoundState(new SoundOnState());
            volume = SOUND_ON_VOLUME;
        } else {
            setSoundState(new SoundOffState());
            volume = SOUND_OFF_VOLUME;
        }
    }
}
