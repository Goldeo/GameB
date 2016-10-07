package com.mygdx.game.actors.figures;

import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.game.screens.GameScreen;

import java.util.Random;

/**
 * Created by Sergey on 06.10.2016.
 */

public class FigureGroup extends Table {

    private final static float WIDTH = 450;
    private final static float HEIGHT = 108;
    private final static float SPACING = 40;
    private GameScreen screen;
    private Random random;

    public FigureGroup(GameScreen screen) {
        this.screen = screen;
        setSize(WIDTH, HEIGHT);
        random = new Random();
        setFigures();
    }

    public void setFigures() {
        Figure figure1 = new FigureBlue1();
        Figure figure2 = new FigureBlue1();
        Figure figure3 = new FigureBlue1();

        add(figure1);
        add(figure2).spaceLeft(SPACING);
        add(figure3).spaceLeft(SPACING);
    }

}
