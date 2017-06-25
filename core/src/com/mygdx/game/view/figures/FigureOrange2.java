package com.mygdx.game.view.figures;

import com.mygdx.game.view.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureOrange2 extends Figure {

    public FigureOrange2(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 3; ++i) {
            panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.ORANGE, BIG_PADDING, i * PANEL_WIDTH + BIG_PADDING);
            panel.setRowAndColumn(i, 0);
            addActor(panel);
        }

        setSize(1, 3, BIG_PADDING, BIG_PADDING);
    }

}
