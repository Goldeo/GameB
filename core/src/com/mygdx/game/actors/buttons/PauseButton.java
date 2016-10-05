package com.mygdx.game.actors.buttons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.GameB;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class PauseButton extends Button {
    private GameScreen screen;

    public PauseButton(final GameScreen screen) {
        this.screen = screen;
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = GameB.skin.getDrawable("pauseLight");
        style.down = GameB.skin.getDrawable("pauseDark");
        setStyle(style);

        setSize(GameB.WIDTH / 10, GameB.WIDTH / 10);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                screen.getGame().setScreen(new PlayScreen(screen.getGame()));
            }
        });
    }
}
