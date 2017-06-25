package com.mygdx.game.view.figures;

import com.mygdx.game.view.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureYellow2 extends Figure {

    public FigureYellow2(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 2; ++i) {
            panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.YELLOW, BIG_PADDING, i * PANEL_WIDTH + BIG_PADDING);
            panel.setRowAndColumn(i, 0);
            addActor(panel);
        }

        setSize(1, 2, BIG_PADDING, BIG_PADDING);
    }

}
