package com.mygdx.game.actors.figures;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.mygdx.game.GameB;
import com.mygdx.game.screens.PlayScreen;

import java.util.Random;

/**
 * Created by Sergey on 06.10.2016.
 */

public class FigureGroup extends Group {

    private static final int FUGIRES_COUNT = 3;
    private Figure[] figures = new Figure[3];
    private PlayScreen screen;
    private Random random = new Random();
    private MoveToAction moveToAction = new MoveToAction();

    public FigureGroup(PlayScreen screen, float x, float y) {
        this.screen = screen;
        moveToAction.setDuration(0.2f);
        moveToAction.setPosition(x, y);
        setPosition(x, y);
        setSize(398, 120);
        setFigures();
    }

    public Figure[] getFigures() {
        return figures;
    }

    public int getFuguresCount() {
        return getChildren().size;
    }

    public void setFigures() {

        if (getFuguresCount() == 0) {

            for (int i = 0; i < FUGIRES_COUNT; ++i) {
                figures[i] = randomFigure();
            }

            figures[0].setPosition(10, getHeight() - figures[0].getHeight() / 2);
            figures[1].setPosition(getWidth() / 2 - figures[1].getWidth() / 2, getHeight() - figures[1].getHeight() / 2);
            figures[2].setPosition(getWidth() - 10 - figures[2].getWidth(), getHeight() - figures[2].getHeight() / 2);

            for (int i = 0; i < FUGIRES_COUNT; ++i) {
                figures[i].setStandardPosition();
                addActor(figures[i]);
            }

            move();
        }
    }

    private void move() {
        setPosition(GameB.WIDTH, 0);
        moveToAction.restart();
        addAction(moveToAction);
    }

    private Figure randomFigure() {
        int randomN = random.nextInt(19);
        return Figure.create(randomN, screen);
    }

}
