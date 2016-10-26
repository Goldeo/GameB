package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureOrange1 extends Figure {

    public FigureOrange1(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 3; ++i) {
            panel = new Panel(screen, Panel.Color.ORANGE, i * PANEL_WIDTH + LITTLE_PADDING, BIG_PADDING);
            panel.setActions(0, i);
            addActor(panel);
        }

        setSize(3, 1, LITTLE_PADDING, BIG_PADDING);
    }

}
