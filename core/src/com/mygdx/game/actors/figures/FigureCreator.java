package com.mygdx.game.actors.figures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.PlayScreen;

import java.util.Random;

/**
 * Created by Sergey on 06.10.2016.
 */

public class FigureCreator extends Group {

    private static final int FUGIRES_COUNT = 3;
    private Figure[] figures = new Figure[3];
    private PlayScreen screen;
    private Random random = new Random();

    public FigureCreator(PlayScreen screen, float x, float y) {
        this.screen = screen;
        setPosition(x, y);
        setSize(398, 120);
        setFigures();
    }

    public int getFuguresCount() {
        return getChildren().size;
    }

    public void setFigures() {

        if (getFuguresCount() == 0) {

            for (int i = 0; i < FUGIRES_COUNT; ++i) {
                figures[i] = new FigureLime(screen);
            }

            figures[0].setPosition(20, getHeight() - figures[0].getHeight() / 2);
            figures[1].setPosition(getWidth() / 2 - figures[1].getWidth() / 2, getHeight() - figures[1].getHeight() / 2);
            figures[2].setPosition(getWidth() - 20 - figures[2].getWidth(), getHeight() - figures[2].getHeight() / 2);

            for (int i = 0; i < FUGIRES_COUNT; ++i) {
                figures[i].setStandartPosition();
                addActor(figures[i]);
            }
        }

    }

    private Figure randomFigure() {
        int randomN = random.nextInt(19);
        return Figure.create(randomN, screen);
    }

}
