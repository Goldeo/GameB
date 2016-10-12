package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureYellow2 extends Figure {

    public FigureYellow2() {
        for (int i = 0; i < 2; ++i) {
            panel = new Panel(Panel.Color.YELLOW);
            panel.setPosition(PADDING_Y, i * PANEL_SPACING + PADDING_Y);
            panel.setActions(i, 0);
            addActor(panel);
        }
        width = Panel.LENGTH + 2 * PADDING_Y;
        height = 2 * Panel.LENGTH + SPACING + 2 * PADDING_Y;
        setSize(width, height);
    }

}
