package com.mygdx.game.actors.figures;

import com.mygdx.game.GameB;
import com.mygdx.game.screens.GameScreen;

import java.util.Random;

/**
 * Created by Sergey on 06.10.2016.
 */

public class FigureCreator {

    private static final float FUGIRES_COUNT = 3;
    private static final float SPACING = 140;
    private static final float BOTTOM_SPACING = 100;

    private Figure figure1, figure2, figure3;
    private GameScreen screen;
    private Random random = new Random();

    public FigureCreator(GameScreen screen) {
        this.screen = screen;
        setFigures();
    }

    public void setFigures() {
        figure1 = new FigureRed2();
        figure2 = randomFigure();
        figure3 = randomFigure();

        figure1.setPosition(GameB.WIDTH / 2 - SPACING - figure1.getWidth() / 2,
                BOTTOM_SPACING  - figure1.getHeight() / 2);
        figure2.setPosition(GameB.WIDTH / 2 - figure2.getWidth() / 2,
                BOTTOM_SPACING  - figure2.getHeight() / 2);
        figure3.setPosition(GameB.WIDTH / 2 + SPACING - figure3.getWidth() / 2,
                BOTTOM_SPACING  - figure3.getHeight() / 2);

        figure1.setStandartPosition();
        figure2.setStandartPosition();
        figure3.setStandartPosition();

        screen.getStage().addActor(figure1);
        screen.getStage().addActor(figure2);
        screen.getStage().addActor(figure3);
    }

    private Figure randomFigure() {
        Figure figure = null;

        int randomN = random.nextInt(19);
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
                figure = new FigureBlue4();
                break;
            case 5:
                figure = new FigureGreen1();
                break;
            case 6:
                figure = new FigureGreen2();
                break;
            case 7:
                figure = new FigureGreen3();
                break;
            case 8:
                figure = new FigureGreen4();
                break;
            case 9:
                figure = new FigureLime();
                break;
            case 10:
                figure = new FigureOrange1();
                break;
            case 11:
                figure = new FigureOrange2();
                break;
            case 12:
                figure = new FigurePink1();
                break;
            case 13:
                figure = new FigurePink2();
                break;
            case 14:
                figure = new FigurePurple();
                break;
            case 15:
                figure = new FigureRed1();
                break;
            case 16:
                figure = new FigureRed2();
                break;
            case 17:
                figure = new FigureYellow1();
                break;
            case 18:
                figure = new FigureYellow2();
                break;
            default:
                break;
        }

        return figure;
    }

}
