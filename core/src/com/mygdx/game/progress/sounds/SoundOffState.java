package com.mygdx.game.progress.sounds;

/**
 * Created by Sergey on 30.04.2017.
 */

public class SoundOffState implements ISoundState {
    @Override
    public void on(SoundsManager soundsManager) {
        soundsManager.setSoundState(new SoundOnState());
        soundsManager.setVolume(SoundsManager.SOUND_ON_VOLUME);
    }

    @Override
    public void off(SoundsManager soundsManager) {
        // not need
    }
}
