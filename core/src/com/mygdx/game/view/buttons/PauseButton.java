package com.mygdx.game.view.buttons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.GameB;
import com.mygdx.game.view.screens.GameScreen;
import com.mygdx.game.view.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class PauseButton extends GameButton {
    public PauseButton(final GameScreen screen) {
        super(screen);
        style.up = skin.getDrawable("pauseLight");
        style.down = skin.getDrawable("pauseDark");
        setSize(GameB.WIDTH / 10, GameB.WIDTH / 10);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((PlayScreen) screen).showMenu();
                playButtonSound();
            }
        });
    }
}
