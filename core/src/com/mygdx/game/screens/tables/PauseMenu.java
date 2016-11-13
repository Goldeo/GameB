package com.mygdx.game.screens.tables;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.game.GameB;
import com.mygdx.game.actors.buttons.ResumeButton;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 01.11.2016.
 */

public class PauseMenu extends Table {

    private static final float DURATION = .3f;
    ResumeButton resumeButton;

    public PauseMenu(PlayScreen screen) {
        resumeButton = new ResumeButton(screen);
        add(resumeButton);
    }

    public void show() {
        addAction(Actions.moveTo(GameB.WIDTH / 2, GameB.HEIGHT / 2, DURATION));
    }

    public void hide() {
        addAction(Actions.moveTo(GameB.WIDTH + 200, GameB.HEIGHT / 2, DURATION));
    }
}
