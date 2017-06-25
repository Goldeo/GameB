package com.mygdx.game.view.figures;

import com.mygdx.game.view.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureOrange1 extends Figure {

    public FigureOrange1(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 3; ++i) {
            panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.ORANGE, i * PANEL_WIDTH + LITTLE_PADDING, BIG_PADDING);
            panel.setRowAndColumn(0, i);
            addActor(panel);
        }

        setSize(3, 1, LITTLE_PADDING, BIG_PADDING);
    }

}
