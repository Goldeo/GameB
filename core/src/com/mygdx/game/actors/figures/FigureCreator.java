package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.screens.GameScreen;

import java.util.Random;

/**
 * Created by Sergey on 06.10.2016.
 */

public class FigureCreator {

    private static final float FUGIRES_COUNT = 3;
    private static final float SPACING = 140;
    private float leftSpacing;
    private float bottomSpacing;
    private Field field;

    private Figure figure1, figure2, figure3;
    private GameScreen screen;
    private Random random = new Random();

    public FigureCreator(GameScreen screen, float leftSpacing, float bottomSpacing) {
        this.screen = screen;
        this.leftSpacing = leftSpacing;
        this.bottomSpacing = bottomSpacing;
        setFigures();
    }



    public void setField(Field field) {
        this.field = field;
    }

    public void setFigures() {
        figure1 = randomFigure();
        figure2 = randomFigure();
        figure3 = randomFigure();

        figure1.setPosition(leftSpacing - SPACING - figure1.getWidth() / 2,
                bottomSpacing  - figure1.getHeight() / 2);
        figure2.setPosition(leftSpacing - figure2.getWidth() / 2,
                bottomSpacing  - figure2.getHeight() / 2);
        figure3.setPosition(leftSpacing + SPACING - figure3.getWidth() / 2,
                bottomSpacing  - figure3.getHeight() / 2);

        figure1.setStandartPosition();
        figure2.setStandartPosition();
        figure3.setStandartPosition();

        screen.getStage().addActor(figure1);
        screen.getStage().addActor(figure2);
        screen.getStage().addActor(figure3);
    }

    private Figure randomFigure() {
        int randomN = random.nextInt(19);
        return Figure.create(randomN, field);
    }

}
