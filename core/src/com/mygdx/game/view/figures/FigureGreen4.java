package com.mygdx.game.view.figures;

import com.mygdx.game.view.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureGreen4 extends Figure {

    public FigureGreen4(PlayScreen screen) {
        super(screen);
        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.GREEN, PANEL_WIDTH + MEDIUM_PADDING, BIG_PADDING);
        panel.setRowAndColumn(0, 1);
        addActor(panel);

        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.GREEN, PANEL_WIDTH + MEDIUM_PADDING, PANEL_WIDTH + BIG_PADDING);
        panel.setRowAndColumn(1, 1);
        addActor(panel);

        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.GREEN, MEDIUM_PADDING, PANEL_WIDTH + BIG_PADDING);
        panel.setRowAndColumn(1, 0);
        addActor(panel);

        setSize(2, 2, MEDIUM_PADDING, BIG_PADDING);
    }

}
