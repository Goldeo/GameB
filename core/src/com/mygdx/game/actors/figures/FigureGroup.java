package com.mygdx.game.actors.figures;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Created by Sergey on 06.10.2016.
 */

public class FigureGroup extends Table {

    private final static float WIDTH = 450;
    private final static float HEIGHT = 40;
    private final static float SPACING = 40;

    public FigureGroup() {
        setSize(WIDTH, HEIGHT);
        setFigures();
    }

    public void setFigures() {
        Figure figure1 = new Figure1();
        Figure figure2 = new Figure1();
        Figure figure3 = new Figure1();
        add(figure1).spaceRight(SPACING);
        add(figure2).spaceRight(SPACING);
        add(figure3).spaceRight(SPACING);
    }

}
