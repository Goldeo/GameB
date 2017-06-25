package com.mygdx.game.view.figures;

import com.mygdx.game.view.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureLime extends Figure {

    public FigureLime(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 2; ++i)
            for (int j = 0; j < 2; ++j) {
                panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.LIME, i * PANEL_WIDTH + MEDIUM_PADDING, j * PANEL_WIDTH + BIG_PADDING);
                panel.setRowAndColumn(j, i);
                addActor(panel);
            }

        setSize(2, 2, MEDIUM_PADDING, BIG_PADDING);
    }

}
