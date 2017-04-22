package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureRed1 extends Figure {

    public FigureRed1(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 5; ++i) {
            panel = new Panel(screen, Panel.Color.RED, i * PANEL_WIDTH, BIG_PADDING);
            panel.setRowAndColumn(0, i);
            addActor(panel);
        }

        setSize(5, 1, NO_PADDING, BIG_PADDING);
    }

}
