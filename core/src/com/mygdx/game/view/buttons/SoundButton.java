package com.mygdx.game.view.buttons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.GameB;
import com.mygdx.game.view.screens.GameScreen;
import com.mygdx.game.progress.sounds.SoundsManager;

/**
 * Created by Sergey on 25.04.2017.
 */

public class SoundButton extends GameButton {
    private transient SoundsManager soundsManager;

    public SoundButton(final GameScreen screen) {
        super(screen);
        soundsManager = screen.getGame().getSoundsManager();

        setStyle();
        setSize(GameB.WIDTH / 6, GameB.WIDTH / 6);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                switchSound();
            }
        });
    }

    private void switchSound() {
        soundsManager.switchSound();
        setStyle();
    }

    private void setStyle() {
        if (soundsManager.isOn()) {
            style.up = skin.getDrawable("soundOnLight");
            style.down = skin.getDrawable("soundOnDark");
        } else {
            style.up = skin.getDrawable("soundOffLight");
            style.down = skin.getDrawable("soundOffDark");
        }
    }
}
