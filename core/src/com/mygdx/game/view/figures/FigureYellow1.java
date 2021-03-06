package com.mygdx.game.view.figures;

import com.mygdx.game.view.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureYellow1 extends Figure {

    public FigureYellow1(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 2; ++i) {
            panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.YELLOW, i * PANEL_WIDTH + MEDIUM_PADDING, BIG_PADDING);
            panel.setRowAndColumn(0, i);
            addActor(panel);
        }

        setSize(2, 1, MEDIUM_PADDING, BIG_PADDING);
    }

}
