package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureRed2 extends Figure {

    public FigureRed2(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 5; ++i) {
            panel = new Panel(screen, Panel.Color.RED, BIG_PADDING, i * PANEL_WIDTH + BIG_PADDING);
            panel.setActions(i, 0);
            addActor(panel);
        }

        setSize(1, 5, BIG_PADDING, BIG_PADDING);
    }

}
