package com.mygdx.game.actors.buttons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.GameB;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 26.10.2016.
 */
public class ResumeButton extends GameButton {
    public ResumeButton(final GameScreen screen) {
        super(screen);
        style.up = skin.getDrawable("playLight");
        style.down = skin.getDrawable("playDark");

        setSize(GameB.WIDTH / 5, GameB.WIDTH / 5);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((PlayScreen) screen).hideMenu();
                screen.getGame().restartGame();
                playButtonSound();
            }
        });
    }
}
