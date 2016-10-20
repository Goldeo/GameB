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
            panel = new Panel(screen, Panel.Color.RED, PADDING_Y, i * PANEL_SPACING + PADDING_Y);
            panel.setActions(i, 0);
            addActor(panel);
        }

        width = Panel.LENGTH + 2 * PADDING_Y;
        height = 5 * Panel.LENGTH + 4 * SPACING + 2 * PADDING_Y;
        setSize(width, height);
    }

}
