package com.mygdx.game.view.figures;

import com.mygdx.game.view.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureBlue2 extends Figure {

    public FigureBlue2(PlayScreen screen) {
        super(screen);
        com.mygdx.game.view.panels.Panel panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.BLUE, PADDING, BIG_PADDING);
        panel.setRowAndColumn(0, 0);
        addActor(panel);

        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.BLUE, PADDING, PANEL_WIDTH + BIG_PADDING);
        panel.setRowAndColumn(1, 0);
        addActor(panel);

        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.BLUE, PADDING, 2 * PANEL_WIDTH + BIG_PADDING);
        panel.setRowAndColumn(2, 0);
        addActor(panel);

        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.BLUE, PANEL_WIDTH + PADDING, 2 * PANEL_WIDTH + BIG_PADDING);
        panel.setRowAndColumn(2, 1);
        addActor(panel);

        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.BLUE, 2 * PANEL_WIDTH + PADDING, 2 * PANEL_WIDTH + BIG_PADDING);
        panel.setRowAndColumn(2, 2);
        addActor(panel);

        setSize(3, 3, PADDING, BIG_PADDING);
    }

}
