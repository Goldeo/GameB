package com.mygdx.game.actors.menus;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.game.GameB;
import com.mygdx.game.actors.buttons.ResumeButton;
import com.mygdx.game.actors.buttons.SoundButton;
import com.mygdx.game.screens.GameScreen;

/**
 * Created by Sergey on 01.11.2016.
 */

public class PauseMenu extends Group {
    private static final float DURATION = .3f;
    private static final int RIGHT_POSITION = GameB.WIDTH + 100;
    private static final int BUTTONS_ALLIGN = 10;
    private Background bg;
    private Table buttons;
    private ResumeButton resumeButton;
    private SoundButton soundButton;

    public PauseMenu(GameScreen screen) {
        resumeButton = new ResumeButton(screen);
        soundButton = new SoundButton(screen);
        bg = new Background(screen);
        bg.setPosition(GameB.WIDTH, 0);
        addActor(bg);

        buttons = new Table();
        buttons.add(resumeButton).padRight(10);
        buttons.add(soundButton);
        buttons.setPosition(RIGHT_POSITION,  GameB.HEIGHT / 2);
        addActor(buttons);
    }

    public void show() {
        bg.addAction(Actions.moveTo(0, 0, 0));
        buttons.addAction(Actions.moveTo(GameB.WIDTH / 2, GameB.HEIGHT / 2, DURATION));
    }

    public void hide() {
        buttons.addAction(Actions.moveTo(RIGHT_POSITION, GameB.HEIGHT / 2, DURATION));
        bg.addAction(Actions.sequence(Actions.delay(DURATION), Actions.moveTo(GameB.WIDTH, 0, 0)));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
