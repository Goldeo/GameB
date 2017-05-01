package com.mygdx.game.progress.sounds;

/**
 * Created by Sergey on 30.04.2017.
 */

public class SoundOnState implements ISoundState {
    @Override
    public void on(SoundsManager soundsManager) {
        // not need
    }

    @Override
    public void off(SoundsManager soundsManager) {
        soundsManager.setSoundState(new SoundOffState());
        soundsManager.setVolume(SoundsManager.SOUND_OFF_VOLUME);
    }
}
