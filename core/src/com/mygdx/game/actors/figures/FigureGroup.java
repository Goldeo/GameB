package com.mygdx.game.actors.figures;

import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.game.GameB;
import com.mygdx.game.screens.GameScreen;

import java.util.Random;

/**
 * Created by Sergey on 06.10.2016.
 */

public class FigureGroup {

    private GameScreen screen;
    private Random random;

    public FigureGroup(GameScreen screen) {
        this.screen = screen;
        random = new Random();
        setFigures();
    }

    public void setFigures() {
        Figure figure1 = new FigureBlue1();
        Figure figure2 = new FigureBlue1();
        Figure figure3 = new FigureBlue1();

        figure1.setPosition(120, 100);
        figure2.setPosition(GameB.WIDTH / 2, 100);
        figure3.setPosition(360, 100);

        figure1.setStandartPosition();
        figure2.setStandartPosition();
        figure3.setStandartPosition();

        screen.getStage().addActor(figure1);
        screen.getStage().addActor(figure2);
        screen.getStage().addActor(figure3);
    }

}
