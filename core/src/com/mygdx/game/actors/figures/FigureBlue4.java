package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureBlue4 extends Figure {

    public FigureBlue4(PlayScreen screen) {
        super(screen);
        panel = new Panel(screen, Panel.Color.BLUE, 2 * PANEL_WIDTH + PADDING, BIG_PADDING);
        panel.setRowAndColumn(0, 2);
        addActor(panel);

        panel = new Panel(screen, Panel.Color.BLUE, 2 * PANEL_WIDTH + PADDING, PANEL_WIDTH + BIG_PADDING);
        panel.setRowAndColumn(1, 2);
        addActor(panel);

        panel = new Panel(screen, Panel.Color.BLUE, 2 * PANEL_WIDTH + PADDING, 2 * PANEL_WIDTH + BIG_PADDING);
        panel.setRowAndColumn(2, 2);
        addActor(panel);

        panel = new Panel(screen, Panel.Color.BLUE, PANEL_WIDTH + PADDING, 2* PANEL_WIDTH + BIG_PADDING);
        panel.setRowAndColumn(2, 1);
        addActor(panel);

        panel = new Panel(screen, Panel.Color.BLUE, PADDING, 2 * PANEL_WIDTH + BIG_PADDING);
        panel.setRowAndColumn(2, 0);
        addActor(panel);

        setSize(3, 3, PADDING, BIG_PADDING);
    }

}
