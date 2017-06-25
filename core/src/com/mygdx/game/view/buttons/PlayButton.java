package com.mygdx.game.view.buttons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.GameB;
import com.mygdx.game.view.screens.GameScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class PlayButton extends GameButton {
    public PlayButton(final GameScreen screen) {
        super(screen);
        style.up = skin.getDrawable("playLight");
        style.down = skin.getDrawable("playDark");

        setSize(GameB.WIDTH / 5, GameB.WIDTH / 5);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                screen.getGame().setScreen(GameB.Screen.PLAY_SCREEN);
                playButtonSound();
            }
        });
    }
}
