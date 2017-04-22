package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigurePink1 extends Figure {

    public FigurePink1(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 4; ++i) {
            panel = new Panel(screen, Panel.Color.PINK, i * PANEL_WIDTH + LITTLE_PADDING, BIG_PADDING);
            panel.setRowAndColumn(0, i);
            addActor(panel);
        }

        setSize(4, 1, LITTLE_PADDING, BIG_PADDING);
    }

}
