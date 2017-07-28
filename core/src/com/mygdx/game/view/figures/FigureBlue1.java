package com.mygdx.game.view.figures;

import com.mygdx.game.view.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureBlue1 extends Figure {

    public FigureBlue1(PlayScreen screen) {
        super(screen);

        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.BLUE, 2 * PANEL_WIDTH + PADDING, BIG_PADDING);
        panel.setRowAndColumn(0, 2);
        addActor(panel);

        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.BLUE, PANEL_WIDTH + PADDING, BIG_PADDING);
        panel.setRowAndColumn(0, 1);
        addActor(panel);

        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.BLUE, PADDING, BIG_PADDING);
        panel.setRowAndColumn(0, 0);
        addActor(panel);

        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.BLUE, PADDING, PANEL_WIDTH + BIG_PADDING);
        panel.setRowAndColumn(1, 0);
        addActor(panel);

        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.BLUE, PADDING, 2 * PANEL_WIDTH + BIG_PADDING);
        panel.setRowAndColumn(2, 0);
        addActor(panel);

        setSize(3, 3, PADDING, BIG_PADDING);
    }

}