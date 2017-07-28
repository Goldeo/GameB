package com.mygdx.game.view.figures;

import com.mygdx.game.view.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigurePink2 extends Figure {

    public FigurePink2(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 4; ++i) {
            panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.PINK, BIG_PADDING, i * PANEL_WIDTH + BIG_PADDING);
            panel.setRowAndColumn(i, 0);
            addActor(panel);
        }

        setSize(1, 4, BIG_PADDING, BIG_PADDING);
    }

}