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

public class PlayButton extends Button {

    private GameScreen screen;

    public PlayButton(final GameScreen screen) {
        this.screen = screen;
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = GameB.skin.getDrawable("playLight");
        style.down = GameB.skin.getDrawable("playDark");

        setStyle(style);
        setSize(GameB.WIDTH / 5, GameB.WIDTH / 5);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                screen.getGame().setScreen(GameB.Screen.PLAY_SCREEN);
            }
        });
    }


}
