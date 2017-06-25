package com.mygdx.game.view.figures;

import com.mygdx.game.view.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureAqua extends Figure {

    public FigureAqua(PlayScreen screen) {
        super(screen);

        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j) {
                panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.AQUA, i * PANEL_WIDTH + LITTLE_PADDING, j * PANEL_WIDTH + BIG_PADDING);
                panel.setRowAndColumn(j, i);
                addActor(panel);
            }

        setSize(3, 3, LITTLE_PADDING, BIG_PADDING);

    }

}
