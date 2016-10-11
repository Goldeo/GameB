package com.mygdx.game.actors.figures;

import com.mygdx.game.GameB;
import com.mygdx.game.screens.GameScreen;

import java.util.Random;

/**
 * Created by Sergey on 06.10.2016.
 */

public class FigureGroup {

    private static final float FUGIRES_COUNT = 3;
    private static final float SPACING = 120;
    private static final float BOTTOM_SPACING = 100;

    private Figure figure1, figure2, figure3;
    private GameScreen screen;
    private Random random = new Random();

    public FigureGroup(GameScreen screen) {
        this.screen = screen;
        setFigures();
    }

    public void setFigures() {
        figure1 = randomFigure();
        figure2 = randomFigure();
        figure3 = randomFigure();

        figure1.setPosition(GameB.WIDTH / 2 - SPACING, BOTTOM_SPACING);
        figure2.setPosition(GameB.WIDTH / 2, BOTTOM_SPACING);
        figure3.setPosition(GameB.WIDTH / 2 + SPACING, BOTTOM_SPACING);

        figure1.setStandartPosition();
        figure2.setStandartPosition();
        figure3.setStandartPosition();

        screen.getStage().addActor(figure1);
        screen.getStage().addActor(figure2);
        screen.getStage().addActor(figure3);

    }

    private Figure randomFigure() {
        Figure figure = null;

        int randomN = random.nextInt(1);
        switch (randomN) {
            case 0:
                figure = new FigureAqua();
                break;
            case 1:
                figure = new FigureBlue1();
                break;
            case 2:
                figure = new FigureBlue2();
                break;
            case 3:
                figure = new FigureBlue3();
                break;
            case 4:
                figure = new FigureBlue3();
                break;
            default:
                break;
        }

        return figure;
    }

}
